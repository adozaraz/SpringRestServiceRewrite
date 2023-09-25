package repositories;

import entities.LearningClass;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class LearningClassRepositoryTest {

    private LearningClassRepository learningClassRepository;

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