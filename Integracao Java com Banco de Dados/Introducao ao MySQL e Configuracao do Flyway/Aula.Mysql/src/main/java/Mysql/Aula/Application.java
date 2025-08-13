package Mysql.Aula;

import Mysql.Aula.persistence.ContactDAO;
import Mysql.Aula.persistence.EmployeeAuditDAO;
import Mysql.Aula.persistence.EmployeeDAO;
import Mysql.Aula.persistence.EmployeeParamDAO;
import Mysql.Aula.persistence.entity.EmployeeEntity;
import Mysql.Aula.persistence.entity.ModuleEntity;
import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

import org.flywaydb.core.Flyway;

import static java.time.ZoneOffset.UTC;

@SpringBootApplication
public class Application {

	private final static EmployeeDAO employeeDAO = new EmployeeDAO();
	private final static EmployeeParamDAO employeeParamDAODAO = new EmployeeParamDAO();
	private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
	private final static ContactDAO contactDAO = new ContactDAO();
	private static final Faker faker = new Faker(new Locale("pt", "BR"));

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:mysql://localhost:3306/jdbc_sample", "root", "admin")
				.load();

		flyway.migrate();

//		var employee = new EmployeeEntity();
//		employee.setName("Antonio");
//		employee.setSalary(new BigDecimal("2600"));
//		employee.setBirthday(OffsetDateTime.now().minusYears(26));
//		System.out.println(employee);
//		employeeDAO.insert(employee);
//		System.out.println(employee);
//
//		var contact = new ContactEntity();
//		contact.setDescription("Miguel@site.com");
//		contact.setType("email");
//		contact.setEmployee(employee);
//		contactDAO.insertBatch(contact);
//
//		var contact1 = new ContactEntity();
//		contact1.setDescription("333333");
//		contact1.setType("celular");
//		contact1.setEmployee(employee);
//		contactDAO.insertBatch(contact1);

//		employeeDAO.findAll().forEach(System.out::println);

//		System.out.println(employeeDAO.findById(18012));

//
//		//employeeDAO.findAll().forEach(System.out::println);
//
////
//		var update = new EmployeeEntity();
////		update.setId(8);
////		update.setName("Joao Guilherme");
////		update.setSalary(new BigDecimal("5600"));
////		update.setBirthday(OffsetDateTime.now().minusYears(18).minusDays(3));
////		employeeDAO.update(update);
//
////		employeeDAO.delete(1);
//
//		employeeAuditDAO.findAll().forEach(System.out::println);

		var entities = Stream.generate(() -> {
			var employee = new EmployeeEntity();
			employee.setName(faker.name().fullName());
			employee.setSalary(new BigDecimal(faker.number().digits(4)));
			employee.setBirthday(OffsetDateTime.of(
					LocalDate.now().minusYears(faker.number().numberBetween(40, 20)),
					LocalTime.MIN,
					UTC
			));
			employee.setModules(new ArrayList<>());
			var moduleAmount = faker.number().numberBetween(1, 4);
			for (int i = 0; i < moduleAmount; i++) {
				var module = new ModuleEntity();
				module.setId(i + 1);
				employee.getModules().add(module);
			}
			return employee;
		}).limit(4000).toList();

		entities.forEach(employeeDAO::insert);

//		employeeDAO.insertBatch(entities);
    }



}
