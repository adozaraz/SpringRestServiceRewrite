package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.LearningClassRepository;
import repositories.StudentRepository;

@ComponentScan
@Configuration
@EnableJpaRepositories("repositories")
public class SpringConfig {
}
