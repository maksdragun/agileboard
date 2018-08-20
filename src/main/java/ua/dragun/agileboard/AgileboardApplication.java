package ua.dragun.agileboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;


/*@Configuration
@ComponentScan
@PropertySource(value = {"classpath:application.properties"})

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		JpaRepositoriesAutoConfiguration.class})*/
@SpringBootApplication
public class AgileboardApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.getDefault());
		SpringApplication.run(AgileboardApplication.class, args);
	}
}
