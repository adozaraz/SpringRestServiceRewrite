package ru.aston.springservice.controllers;

import ru.aston.springservice.entities.LearningClassDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.springservice.services.LearningClassService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LearningClassControllerTest {

    private LearningClassController learningClassController;

    private LearningClassService learningClassService;

    @BeforeEach
    void setUp() {
        learningClassService = mock(LearningClassService.class);
        learningClassController = new LearningClassController(learningClassService);
    }

    @Test
    void createLearningClass() throws Exception {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setTitle("Test");
        expected.setDescription("Desc");
        when(learningClassService.create(expected)).thenReturn(expected);

        LearningClassDTO actual = learningClassController.createLearningClass(expected);
        assertEquals(expected, actual);
    }

    @Test
    void readLearningClass() throws Exception {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setLearningClassId(UUID.randomUUID().toString());
        expected.setTitle("Test");
        expected.setDescription("Desc");
        when(learningClassService.read(Long.parseLong(expected.getLearningClassId()))).thenReturn(expected);

        LearningClassDTO actual = learningClassController.readLearningClass(Long.parseLong(expected.getLearningClassId()));
        assertEquals(expected, actual);
    }

    @Test
    void updateLearningClass() throws Exception {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setTitle("Test");
        expected.setDescription("Desc");
        when(learningClassService.update(expected)).thenReturn(expected);

        LearningClassDTO actual = learningClassController.updateLearningClass(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deleteLearningClass() throws Exception {
        LearningClassDTO expected = new LearningClassDTO();
        expected.setTitle("Test");
        expected.setDescription("Desc");

        learningClassController.deleteLearningClass(expected);

        verify(learningClassService, atLeastOnce()).delete(any(LearningClassDTO.class));
    }
}