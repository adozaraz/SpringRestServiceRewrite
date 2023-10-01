package config;

import controllers.LearningClassController;
import controllers.StudentController;
import mappers.LearningClassMapper;
import mappers.LearningClassMapperImpl;
import mappers.StudentMapper;
import mappers.StudentMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repositories.LearningClassRepository;
import repositories.StudentRepository;
import services.LearningClassService;
import services.StudentService;

@ComponentScan
@Configuration
public class SpringConfig {
    @Bean
    public LearningClassService learningClassService(LearningClassRepository learningClassRepository, LearningClassMapper learningClassMapper) {
        return new LearningClassService(learningClassRepository, learningClassMapper);
    }

    @Bean
    public StudentService studentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        return new StudentService(studentRepository, studentMapper);
    }

    @Bean
    public StudentMapper studentMapper() {
        return new StudentMapperImpl();
    }

    @Bean
    public LearningClassMapper learningClassMapper() {
        return new LearningClassMapperImpl();
    }

    @Bean
    public LearningClassController learningClassController(LearningClassService learningClassService) {
        return new LearningClassController(learningClassService);
    }

    @Bean
    public StudentController studentController(StudentService studentService) {
        return new StudentController(studentService);
    }
}
