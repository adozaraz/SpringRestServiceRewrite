package ru.aston.springservice.repositories;

import ru.aston.springservice.config.PersistenceContext;
import ru.aston.springservice.entities.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
@ContextConfiguration(classes = PersistenceContext.class)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"))
            .withInitScript("db.sql");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("db.url", postgres::getJdbcUrl);
        registry.add("db.username", postgres::getUsername);
        registry.add("db.password", postgres::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @Test
    void create() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");

        Student actual = studentRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void read() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        Optional<Student> actual = studentRepository.findById(expected.getStudentId());
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void update() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        expected.setFirstName("Lamia");
        Student actual = studentRepository.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {
        Student expected = new Student();
        expected.setLastName("Boradulin");
        expected.setFirstName("Nikita");
        studentRepository.save(expected);

        studentRepository.delete(expected);
        Optional<Student> actual = studentRepository.findById(expected.getStudentId());
        assertFalse(actual.isPresent());
    }

}