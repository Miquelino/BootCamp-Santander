package Mysql.Aula.persistence.entity;

import Mysql.Aula.persistence.ConnectionUtil;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {

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
                var startement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?")
        ){
            startement.executeQuery("SELECT * FROM employees WHERE id = " + id);
            startement.setLong(1, id);
            var resultSet = startement.getResultSet();
            if (resultSet.next()){
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstante = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstante, UTC));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return entity;
    }
}
