ALTER TABLE subjects DROP COLUMN subject_name;
ALTER TABLE subjects
    ADD COLUMN name VARCHAR(255) NOT NULL;