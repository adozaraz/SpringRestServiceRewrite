package ru.aston.springservice.entities;

import java.util.Objects;
import java.util.Set;

public class LearningClassDTO {
    private String learningClassId;
    private String title;
    private String description;

    private Set<StudentDTO> attendingStudents;

    public LearningClassDTO() {
    }

    public String getLearningClassId() {
        return learningClassId;
    }

    public void setLearningClassId(String learningClassId) {
        this.learningClassId = learningClassId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }


    public Set<StudentDTO> getAttendingStudents() {
        return attendingStudents;
    }

    public void setAttendingStudents(Set<StudentDTO> attendingStudents) {
        this.attendingStudents = attendingStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearningClassDTO that = (LearningClassDTO) o;
        return Objects.equals(learningClassId, that.learningClassId) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(attendingStudents, that.attendingStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(learningClassId, title, description, attendingStudents);
    }
}
