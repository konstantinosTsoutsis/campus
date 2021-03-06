-- Generated by Oracle SQL Developer Data Modeler 21.1.0.092.1221
--   at:        2021-05-23 22:11:30 EEST
--   site:      Oracle Database 12c
--   type:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE campus (
    campus_name      VARCHAR2(100) NOT NULL,
    address          VARCHAR2(100) NOT NULL,
    distance         VARCHAR2(100) NOT NULL,
    bus_num          NUMBER NOT NULL,
    club_club_name   VARCHAR2(100) NOT NULL,
    club_club_name1  VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX campus__idx ON
    campus (
        club_club_name
    ASC );

CREATE UNIQUE INDEX campus__idxv1 ON
    campus (
        club_club_name1
    ASC );

ALTER TABLE campus ADD CONSTRAINT campus_pk PRIMARY KEY ( campus_name );

CREATE TABLE club (
    club_name           VARCHAR2(100) NOT NULL,
    building            VARCHAR2(100) NOT NULL,
    phone               NUMBER NOT NULL,
    sports_num          NUMBER NOT NULL,
    campus_campus_name  VARCHAR2(100) NOT NULL,
    sports_list         VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX club__idx ON
    club (
        campus_campus_name
    ASC );

ALTER TABLE club ADD CONSTRAINT club_pk PRIMARY KEY ( club_name );

CREATE TABLE commission (
    commission_name       VARCHAR2(100) NOT NULL,
    faculty_faculty_name  VARCHAR2(100) NOT NULL
);

ALTER TABLE commission ADD CONSTRAINT commission_pk PRIMARY KEY ( commission_name );

CREATE TABLE course (
    course_id           VARCHAR2(100) NOT NULL,
    course_name         VARCHAR2(100) NOT NULL,
    curriculum_curr_id  VARCHAR2(100) NOT NULL
);

ALTER TABLE course ADD CONSTRAINT class_pk PRIMARY KEY ( course_id );

CREATE TABLE curriculum (
    curr_id                VARCHAR2(100) NOT NULL,
    title                  VARCHAR2(100) NOT NULL,
    "level"                VARCHAR2(100) NOT NULL,
    duration               VARCHAR2(100) NOT NULL,
    department_dept_name   VARCHAR2(100) NOT NULL,
    department_dept_name1  VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX curriculum__idx ON
    curriculum (
        department_dept_name
    ASC );

ALTER TABLE curriculum ADD CONSTRAINT curriculum_pk PRIMARY KEY ( curr_id );

CREATE TABLE department (
    dept_name             VARCHAR2(100) NOT NULL,
    faculty_faculty_name  VARCHAR2(100) NOT NULL,
    campus_campus_name    VARCHAR2(100) NOT NULL,
    curriculum_curr_id    VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX department__idx ON
    department (
        curriculum_curr_id
    ASC );

ALTER TABLE department ADD CONSTRAINT department_pk PRIMARY KEY ( dept_name );

CREATE TABLE faculty (
    faculty_name  VARCHAR2(100) NOT NULL,
    dean          VARCHAR2(100) NOT NULL,
    building      VARCHAR2(100) NOT NULL
);

ALTER TABLE faculty ADD CONSTRAINT faculty_pk PRIMARY KEY ( faculty_name );

CREATE TABLE prerequisite_courses (
    prerequisite_id    VARCHAR2(100) NOT NULL,
    prerequisite_name  VARCHAR2(100) NOT NULL,
    course_course_id   VARCHAR2(100) NOT NULL
);

CREATE TABLE relation_13 (
    course_course_id    VARCHAR2(100) NOT NULL,
    teacher_teacher_id  VARCHAR2(100) NOT NULL
);

ALTER TABLE relation_13 ADD CONSTRAINT relation_13_pk PRIMARY KEY ( course_course_id,
                                                                    teacher_teacher_id );

CREATE TABLE relation_15 (
    commission_commission_name  VARCHAR2(100) NOT NULL,
    teacher_teacher_id          VARCHAR2(100) NOT NULL
);

ALTER TABLE relation_15 ADD CONSTRAINT relation_15_pk PRIMARY KEY ( commission_commission_name,
                                                                    teacher_teacher_id );

CREATE TABLE student (
    student_id          VARCHAR2(100) NOT NULL,
    first_name          VARCHAR2(100) NOT NULL,
    last_name           VARCHAR2(100) NOT NULL,
    fathers_name        VARCHAR2(100) NOT NULL,
    date_of_birth       DATE NOT NULL,
    registration_date   DATE NOT NULL,
    curriculum_curr_id  VARCHAR2(100) NOT NULL
);

ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( student_id );

CREATE TABLE student_course (
    student_student_id  VARCHAR2(100) NOT NULL,
    course_course_id    VARCHAR2(100) NOT NULL,
    year_of_attendance  VARCHAR2(100) NOT NULL,
    grade               NUMBER NOT NULL,
    registration_date   DATE NOT NULL
);

ALTER TABLE student_course ADD CONSTRAINT student_course_pk PRIMARY KEY ( student_student_id,
                                                                          course_course_id );

CREATE TABLE supervisor (
    supervisor_id VARCHAR2(100) NOT NULL
);

ALTER TABLE supervisor ADD CONSTRAINT supervisor_pk PRIMARY KEY ( supervisor_id );

CREATE TABLE teacher (
    department_dept_name      VARCHAR2(100) NOT NULL,
    teacher_id                VARCHAR2(100) NOT NULL,
    first_name                VARCHAR2(100) NOT NULL,
    last_name                 VARCHAR2(100) NOT NULL,
    title                     VARCHAR2(100) NOT NULL,
    office_number             NUMBER NOT NULL,
    supervisor_supervisor_id  VARCHAR2(100) NOT NULL
);

ALTER TABLE teacher ADD CONSTRAINT teacher_pk PRIMARY KEY ( teacher_id );

ALTER TABLE commission
    ADD CONSTRAINT commission_faculty_fk FOREIGN KEY ( faculty_faculty_name )
        REFERENCES faculty ( faculty_name );

ALTER TABLE course
    ADD CONSTRAINT course_curriculum_fk FOREIGN KEY ( curriculum_curr_id )
        REFERENCES curriculum ( curr_id );

ALTER TABLE curriculum
    ADD CONSTRAINT curriculum_department_fk FOREIGN KEY ( department_dept_name1 )
        REFERENCES department ( dept_name );

ALTER TABLE department
    ADD CONSTRAINT department_campus_fk FOREIGN KEY ( campus_campus_name )
        REFERENCES campus ( campus_name );

ALTER TABLE department
    ADD CONSTRAINT department_faculty_fk FOREIGN KEY ( faculty_faculty_name )
        REFERENCES faculty ( faculty_name );

ALTER TABLE prerequisite_courses
    ADD CONSTRAINT prerequisite_courses_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

ALTER TABLE relation_13
    ADD CONSTRAINT relation_13_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

ALTER TABLE relation_13
    ADD CONSTRAINT relation_13_teacher_fk FOREIGN KEY ( teacher_teacher_id )
        REFERENCES teacher ( teacher_id );

ALTER TABLE relation_15
    ADD CONSTRAINT relation_15_commission_fk FOREIGN KEY ( commission_commission_name )
        REFERENCES commission ( commission_name );

ALTER TABLE relation_15
    ADD CONSTRAINT relation_15_teacher_fk FOREIGN KEY ( teacher_teacher_id )
        REFERENCES teacher ( teacher_id );

ALTER TABLE student_course
    ADD CONSTRAINT student_course_course_fk FOREIGN KEY ( course_course_id )
        REFERENCES course ( course_id );

ALTER TABLE student_course
    ADD CONSTRAINT student_course_student_fk FOREIGN KEY ( student_student_id )
        REFERENCES student ( student_id );

ALTER TABLE student
    ADD CONSTRAINT student_curriculum_fk FOREIGN KEY ( curriculum_curr_id )
        REFERENCES curriculum ( curr_id );

ALTER TABLE teacher
    ADD CONSTRAINT teacher_department_fk FOREIGN KEY ( department_dept_name )
        REFERENCES department ( dept_name );

ALTER TABLE teacher
    ADD CONSTRAINT teacher_supervisor_fk FOREIGN KEY ( supervisor_supervisor_id )
        REFERENCES supervisor ( supervisor_id );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             5
-- ALTER TABLE                             28
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
