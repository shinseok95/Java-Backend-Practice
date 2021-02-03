package spring.todo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"spring.todo.dao","spring.todo.service"})
@Import({MyBatisConfig.class})
@EnableTransactionManagement

// dao, service를 위해 필요한 공통된 부분을 담당
public class ApplicationConfig {
	
	// 데이터 소스 
	@Bean
	public DataSource dataSource() {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("TIGER");
		
		return dataSource;
	}
	
	// 트랜잭션를 위해 DataSource와 connection
	@Bean
	public PlatformTransactionManager transcationManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}
}
