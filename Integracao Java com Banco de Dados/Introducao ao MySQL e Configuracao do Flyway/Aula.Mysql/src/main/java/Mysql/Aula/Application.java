package Mysql.Aula;

import Mysql.Aula.persistence.ConnectionUtil;
import Mysql.Aula.persistence.entity.EmployeeAuditDAO;
import Mysql.Aula.persistence.entity.EmployeeDAO;
import Mysql.Aula.persistence.entity.EmployeeEntity;
import Mysql.Aula.persistence.entity.EmployeeParamDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.time.OffsetDateTime;

import org.flywaydb.core.Flyway;

@SpringBootApplication
public class Application {

	private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
	private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:mysql://localhost:3306/jdbc_sample", "root", "admin")
				.load();

		flyway.migrate();

		var insert = new EmployeeEntity();
		insert.setName("Antonio");
		insert.setSalary(new BigDecimal("2600"));
		insert.setBirthday(OffsetDateTime.now().minusYears(26));
		System.out.println(insert);
		employeeDAO.insertWithProcedure(insert);
		System.out.println(insert);

		//employeeDAO.findAll().forEach(System.out::println);

//
		var update = new EmployeeEntity();
//		update.setId(8);
//		update.setName("Joao Guilherme");
//		update.setSalary(new BigDecimal("5600"));
//		update.setBirthday(OffsetDateTime.now().minusYears(18).minusDays(3));
//		employeeDAO.update(update);

//		employeeDAO.delete(1);

		employeeAuditDAO.findAll().forEach(System.out::println);
    }

}
