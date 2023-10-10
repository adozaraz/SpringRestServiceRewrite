CREATE DATABASE students_database ENCODING 'UTF-8';

---Студенты
CREATE TABLE IF NOT EXISTS students (
                                        studentId SERIAL PRIMARY KEY,
                                        firstName VARCHAR NOT NULL,
                                        lastName VARCHAR NOT NULL
);

---Списки классов
CREATE TABLE IF NOT EXISTS learning_classes (
                                               learningClassId SERIAL PRIMARY KEY,
                                               title VARCHAR NOT NULL,
                                               description VARCHAR NOT NULL
);

---Списки записей в классы
CREATE TABLE IF NOT EXISTS enrollments (
                                           enrollmentId SERIAL PRIMARY KEY,
                                           student SERIAL NOT NULL,
                                           learningClass SERIAL NOT NULL,
                                           FOREIGN KEY (student) REFERENCES students (studentId),
    FOREIGN KEY (learningClass) REFERENCES learning_classes (learningClassId)
    );