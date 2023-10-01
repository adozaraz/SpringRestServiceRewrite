package repositories;

import config.SpringConfig;
import config.SpringContextHolder;
import config.SpringJpaConfig;
import config.SpringRepositoryContextHolder;
import entities.LearningClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringRepositoryContextHolder.class})
class LearningClassRepositoryTest {

    private LearningClassRepository learningClassRepository;

    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"));

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }


    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @BeforeEach
    void setUp() {

        ApplicationContext context = SpringRepositoryContextHolder.getApplicationContext();
        learningClassRepository = (LearningClassRepository) context.getBean(LearningClassRepository.class);
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
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