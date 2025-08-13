package Mysql.Aula.persistence;

import Mysql.Aula.persistence.entity.ContactEntity;
import Mysql.Aula.persistence.entity.EmployeeEntity;
import Mysql.Aula.persistence.entity.ModuleEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {

    private final ContactDAO contactDAO = new ContactDAO();
    private final AccessDAO accessDAO = new AccessDAO();

    public void insertWithProcedure(final EmployeeEntity entity) {
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareCall(
                     "call prc_insert_employee(?, ?, ?, ?);"
             )
        ) {
            statement.registerOutParameter(1, LONG);
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getSalary());
            statement.setTimestamp(4,
                    Timestamp.valueOf(entity.getBirthday().atZoneSameInstant(UTC).toLocalDateTime()));
            statement.execute();
            entity.setId(statement.getLong(1));
            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insert(EmployeeEntity entity) {
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(
                     "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?);",
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statement.executeUpdate();

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
                entity.getModules().stream()
                        .map(ModuleEntity::getId)
                        .forEach(m -> accessDAO.insert(entity.getId(), m));
            }
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir employee, nenhuma linha afetada.");
            }

            try (var generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao obter ID gerado.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertBatch(final List<EmployeeEntity> entities) {
        try (var connection = ConnectionUtil.getConnection()) {
            var sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?);";
            try (var statement = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);
                for (int i = 0; i < entities.size(); i++) {

                    statement.setString(1, entities.get(i).getName());
                    statement.setBigDecimal(2, entities.get(i).getSalary());
                    var timesTamp = Timestamp.valueOf(entities.get(i).getBirthday()
                            .atZoneSameInstant(UTC)
                            .toLocalDateTime());
                    statement.setTimestamp(3, timesTamp);
                    statement.addBatch();
                    if (i % 1000 == 0 || i == entities.size() - 1) statement.executeBatch();

                    if (i == 8000) throw new SQLException();
                }
                statement.executeBatch();
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity) {
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "UPDATE employees set name = ? salary = ?, birthday = ? WHERE id = ?"
                )
        ){
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSameInstant(UTC).toLocalDateTime()));
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(final long id) {
        try (var connection = ConnectionUtil.getConnection();
             var startement = connection.prepareStatement("DELETE FROM employees WHERE id = ?")) {
            startement.setLong(1, id);
            startement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public EmployeeEntity findById(final long id) {
        var entity = new EmployeeEntity();
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT e.id AS e_id, e.name, e.salary, e.birthday, " +
                                "c.id AS c_id, c.description, c.type " +
                                "FROM employees e " +
                                "LEFT JOIN contacts c ON c.employee_id = e.id " +
                                "WHERE e.id = ?"
                )
        ){
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                entity.setId(resultSet.getLong("e_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstante = resultSet.getTimestamp("birthday");
                if (birthdayInstante != null) {
                    entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstante.toInstant(), UTC));
                }

                long contactId = resultSet.getLong("c_id");
                if (!resultSet.wasNull()) {
                    var contact = new ContactEntity();
                    contact.setId(contactId);
                    contact.setDescription(resultSet.getString("description"));
                    contact.setType(resultSet.getString("type"));
                    entity.setModuleContacts(contactDAO.findByEmployeeId(resultSet.getLong("id")));
                    entity.getModuleContacts().add(contact);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return entity;
    }

}
