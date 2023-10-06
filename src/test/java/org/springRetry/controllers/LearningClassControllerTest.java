package org.springRetry.controllers;

import org.springRetry.entities.LearningClassDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springRetry.services.LearningClassService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
        when(learningClassService.read(UUID.fromString(expected.getLearningClassId()))).thenReturn(expected);

        LearningClassDTO actual = learningClassController.readLearningClass(UUID.fromString(expected.getLearningClassId()));
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