package ru.aston.springservice.config;

import ru.aston.springservice.controllers.LearningClassController;
import ru.aston.springservice.controllers.StudentController;
import ru.aston.springservice.mappers.LearningClassMapper;
import ru.aston.springservice.mappers.LearningClassMapperImpl;
import ru.aston.springservice.mappers.StudentMapper;
import ru.aston.springservice.mappers.StudentMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.aston.springservice.repositories.LearningClassRepository;
import ru.aston.springservice.repositories.StudentRepository;
import ru.aston.springservice.services.LearningClassService;
import ru.aston.springservice.services.StudentService;

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
