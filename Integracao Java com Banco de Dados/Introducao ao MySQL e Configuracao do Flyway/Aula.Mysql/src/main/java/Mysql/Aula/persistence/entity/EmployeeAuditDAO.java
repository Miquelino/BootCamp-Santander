package Mysql.Aula.persistence.entity;

import Mysql.Aula.persistence.ConnectionUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class EmployeeAuditDAO {

    public List<EmployeeAuditEntity> findAll() {
        List<EmployeeAuditEntity> entities = new ArrayList<>();
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ){
            statement.executeQuery("SELECT * FROM view_employee_audit");
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Timestamp tsBirthday = resultSet.getTimestamp("birthday");
                var birthday = (tsBirthday == null) ? null :
                        OffsetDateTime.ofInstant(tsBirthday.toInstant(), UTC);

                Timestamp tsOldBirthday = resultSet.getTimestamp("old_birthday");
                var oldBirthday = (tsOldBirthday == null) ? null :
                        OffsetDateTime.ofInstant(tsOldBirthday.toInstant(), UTC);
                entities.add(new EmployeeAuditEntity(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("old_name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getBigDecimal("old_salary"),
                        birthday,
                        oldBirthday,
                        OperationEnum.getByDbOperation(resultSet.getString("operation"))
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return entities;
    }


}
