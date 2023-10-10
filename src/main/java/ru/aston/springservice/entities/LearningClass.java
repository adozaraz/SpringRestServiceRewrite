package ru.aston.springservice.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "learning_classes")
public class LearningClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long learningClassId;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "learningClasses", fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    public Long getLearningClassId() {
        return learningClassId;
    }

    public void setLearningClassId(Long learningClassId) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> attendingStudents) {
        this.students = attendingStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearningClass that = (LearningClass) o;
        return Objects.equals(learningClassId, that.learningClassId) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(learningClassId, title, description, students);
    }
}
