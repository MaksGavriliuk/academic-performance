CREATE TABLE subjects
(
    id           BIGSERIAL PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE assessments
(
    id         BIGSERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score      INT NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

