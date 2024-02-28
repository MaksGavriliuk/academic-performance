CREATE TABLE subjects
(
    id           BIGSERIAL PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);

CREATE TABLE assessments
(
    id         BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    score      INT    NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);