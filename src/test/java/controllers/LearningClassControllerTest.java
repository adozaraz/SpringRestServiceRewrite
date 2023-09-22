package controllers;

import entities.LearningClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import services.LearningClassService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LearningClassControllerTest {

    @InjectMocks
    private LearningClassController learningClassController;

    @Mock
    private LearningClassService learningClassService;

    private LearningClass learningClass;

    @BeforeEach
    void setUp() {
        learningClass = new LearningClass();
        learningClass.setTitle("Infinite");
        learningClass.setDescription("Power");
        learningClass.setLearningClassId(UUID.randomUUID());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createLearningClass() {

    }

    @Test
    void readLearningClass() {
    }

    @Test
    void updateLearningClass() {
    }

    @Test
    void deleteLearningClass() {
    }
}