package ru.aston.springservice.repositories;

import ru.aston.springservice.config.PersistenceContext;
import ru.aston.springservice.entities.LearningClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersistenceContext.class})
class LearningClassRepositoryTest {

    @Autowired
    private LearningClassRepository learningClassRepository;

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"))
            .withInitScript("db.sql");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("db.url", postgres::getJdbcUrl);
        registry.add("db.username", postgres::getUsername);
        registry.add("db.password", postgres::getPassword);
    }

    @Test
    void create() {
        LearningClass expected = new LearningClass();
        expected.setTitle("Test");
        expected.setDescription("Description");

        LearningClass actual = learningClassRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void read() {
        LearningClass expected = new LearningClass();
        expected.setTitle("Test");
        expected.setDescription("Description");
        learningClassRepository.save(expected);

        Optional<LearningClass> actual = learningClassRepository.findById(expected.getLearningClassId());
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void update() {
        LearningClass expected = new LearningClass();
        expected.setTitle("Test");
        expected.setDescription("Description");
        learningClassRepository.save(expected);

        expected.setTitle("Trial");
        LearningClass actual = learningClassRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        LearningClass expected = new LearningClass();
        expected.setTitle("Test");
        expected.setDescription("Description");
        learningClassRepository.save(expected);

        learningClassRepository.delete(expected);
        Optional<LearningClass> actual = learningClassRepository.findById(expected.getLearningClassId());
        assertFalse(actual.isPresent());
    }
}