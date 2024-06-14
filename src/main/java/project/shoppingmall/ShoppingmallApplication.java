package project.shoppingmall;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;
import java.sql.Connection;

@EnableJpaAuditing
@SpringBootApplication
public class ShoppingmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
				.setFieldMatchingEnabled(true);
		return modelMapper;
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource){
		return args -> {
			// 실행 코드
			Connection connection = dataSource.getConnection();
		};
	}

}
