package Mysql.Aula.persistence;

import Mysql.Aula.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;

public class AccessDAO {

    public void insert(final long employeeId, final long moduleId){
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement("INSERT INTO accesses (module_id, employee_id) values (?, ?);")
        ){
            statement.setLong(1, employeeId);
            statement.setLong(2, moduleId);
            statement.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }



}
