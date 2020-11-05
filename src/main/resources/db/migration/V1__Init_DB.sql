DROP TABLE IF EXISTS candidates;

CREATE TABLE IF NOT EXISTS candidates(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    about VARCHAR(1000)
);

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users(
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      password VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL,
      candidate_id BIGINT,
      FOREIGN KEY(candidate_id) REFERENCES candidates
);

DROP TABLE IF EXISTS recommendations;

CREATE TABLE IF NOT EXISTS recommendations(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(50) NOT NULL,
    characteristic VARCHAR(100) NOT NULL,
    candidate_id BIGINT,
    FOREIGN KEY(candidate_id) REFERENCES candidates
);

DROP TABLE IF EXISTS job_vacancies;

CREATE TABLE IF NOT EXISTS job_vacancies(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job VARCHAR(50) NOT NULL,
    company VARCHAR(50) NOT NULL,
    about VARCHAR(1000),
    location VARCHAR(100)
);

DROP TABLE IF EXISTS responses;

CREATE TABLE IF NOT EXISTS candidate_responses(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    candidate_id BIGINT,
    FOREIGN KEY(candidate_id) REFERENCES candidates,
    job_vacancy_id BIGINT,
    FOREIGN KEY(job_vacancy_id) REFERENCES job_vacancies
);

INSERT INTO job_vacancies(job, company, about, location) VALUES('js developer','pst_labs','great company','ul. Shafarnynaskogo d. 56');
INSERT INTO job_vacancies(job, company, about, location) VALUES('java developer','epam','international company','ul. Kopitnaya d.24');
INSERT INTO job_vacancies(job, company, about, location) VALUES('C# developer','softarex','large company', 'ul. Gorodeckaya d. 78');
INSERT INTO job_vacancies(job, company, about, location) VALUES('c++ developer','sam-solutions','rich company', 'ul. Sevkovskogo d. 48');

INSERT INTO candidates(first_name,last_name,about) VALUES('pavel','chebonenko','great developer');
INSERT INTO candidates(first_name,last_name,about) VALUES('liza','semashko','good developer');
INSERT INTO candidates(first_name,last_name,about) VALUES('alex','galkoscvky','good developer');
INSERT INTO candidates(first_name,last_name,about) VALUES('nikita','alexandrov','good developer');
INSERT INTO candidates(first_name,last_name,about) VALUES('ivan','drutko','good developer');
INSERT INTO candidates(first_name,last_name,about) VALUES('alla','scherba','okay developer');

INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(1,1);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(1,2);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(1,3);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(1,4);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(2,1);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(2,2);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(3,1);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(3,2);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(3,3);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(4,1);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(5,1);
INSERT INTO candidate_responses(candidate_id, job_vacancy_id) VALUES(6,1);

INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('pst_labs','good java skills',1);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('epam','good js skills',1);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('softarex','good java skills',1);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('pst_labs','bad java skills',2);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('epam','bad js skills',2);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('softarex','bad java skills',2);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('pst_labs','fine java skills',3);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('epam','fine js skills',3);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('softarex','fine java skills',3);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('sam-solutions','fine java skills',4);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('wargaming','fine js skills',4);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('samsung','fine java skills',5);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('huawei','fine js skills',5);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('sam-solutions','fine java skills',6);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('wargaming','fine js skills',6);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('samsung','fine java skills',6);
INSERT INTO recommendations(company,characteristic, candidate_id) VALUES('huawei','fine js skills',6);


INSERT INTO users(name,password,email, candidate_id) VALUES('pvl','1chebonenko1','farengeit.33@gmail.com', 1);
INSERT INTO users(name,password,email, candidate_id) VALUES('liza','1smashko1','liza.3g3@gmail.com', 2);
INSERT INTO users(name,password,email, candidate_id) VALUES('alx','1glkovsk1','alx.243@gmail.com', 3);
INSERT INTO users(name,password,email, candidate_id) VALUES('nikita','1alx1','nikita.135@gmail.com', 4);
INSERT INTO users(name,password,email, candidate_id) VALUES('ivn','1drut1','ivn.335@gmail.com', 5);
INSERT INTO users(name,password,email, candidate_id) VALUES('alla','1alla1','alla.334@gmail.com', 6);