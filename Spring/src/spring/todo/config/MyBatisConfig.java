package spring.todo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		
		annotationClass = Mapper.class,
		basePackages = "spring.todo.dao",
		sqlSessionFactoryRef = "sqlSessionFactoryBean"
		)
public class MyBatisConfig {
	
	@Bean 
	SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext context) throws IOException{
		
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setConfigLocation(context.getResource("classpath:mybatis/MybatisConfiguration.xml"));
		sessionFactoryBean.setMapperLocations(context.getResources("classpath:mybatis/mappers/**/*.xml"));
		
		return sessionFactoryBean;
	}
}
