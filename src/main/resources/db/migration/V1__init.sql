CREATE TABLE assessments
(
    id         BIGSERIAL INT PRIMARY KEY,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score      INT NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

CREATE TABLE subjects
(
    id           BIGSERIAL INT PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);