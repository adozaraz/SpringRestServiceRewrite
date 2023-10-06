package org.springRetry.config;

import org.springRetry.controllers.LearningClassController;
import org.springRetry.controllers.StudentController;
import org.springRetry.mappers.LearningClassMapper;
import org.springRetry.mappers.LearningClassMapperImpl;
import org.springRetry.mappers.StudentMapper;
import org.springRetry.mappers.StudentMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springRetry.repositories.LearningClassRepository;
import org.springRetry.repositories.StudentRepository;
import org.springRetry.services.LearningClassService;
import org.springRetry.services.StudentService;

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
