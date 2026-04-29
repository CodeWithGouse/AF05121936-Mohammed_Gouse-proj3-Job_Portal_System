CREATE DATABASE job_portal_db;
USE job_portal_db;


CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role ENUM('job_seeker','employer') NOT NULL
);

CREATE TABLE jobs (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    company VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    salary DOUBLE CHECK (salary > 0)
);


CREATE TABLE applications (
    app_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    job_id INT,
    status VARCHAR(20) DEFAULT 'Applied',

    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (job_id) REFERENCES jobs(job_id)
        ON DELETE CASCADE
);

INSERT INTO users (name, email, password, role) VALUES
('Rahul', 'rahul@gmail.com', '1234', 'job_seeker'),
('Ayesha', 'ayesha@gmail.com', '1234', 'job_seeker'),
('Kiran', 'kiran@gmail.com', '1234', 'employer'),
('Meena', 'meena@gmail.com', '1234', 'employer'),
('Arjun', 'arjun@gmail.com', '1234', 'job_seeker');

select * from users;

INSERT INTO jobs (title, company, location, salary) VALUES
('Java Developer', 'TCS', 'Bangalore', 50000),
('Web Developer', 'Infosys', 'Hyderabad', 45000),
('Software Engineer', 'Wipro', 'Chennai', 55000),
('Backend Developer', 'Accenture', 'Pune', 60000),
('Frontend Developer', 'HCL', 'Delhi', 40000);

INSERT INTO jobs (title, company, location, salary) VALUES
('Full Stack Developer', 'Capgemini', 'Mumbai', 65000),
('Data Analyst', 'IBM', 'Bangalore', 70000),
('Python Developer', 'Zoho', 'Chennai', 48000);

select * from jobs;

INSERT INTO applications (user_id, job_id, status) VALUES
(1, 1, 'Applied'),
(2, 2, 'Applied'),
(1, 3, 'Applied'),
(3, 4, 'Applied'),
(5, 1, 'Applied');

select * from applications;

