/**
 * Users table
 */
CREATE TABLE IF NOT EXISTS User (
   Id INT NOT NULL AUTO_INCREMENT COMMENT 'User ID',
   Username Varchar(24) NOT NULL COMMENT 'Username',
   Password Varchar(24) NOT NULL COMMENT 'Password',
   Email Varchar(80) NOT NULL COMMENT 'Email',
   Firstname Varchar(24) NOT NULL COMMENT 'First Name',
   Lastname Varchar(60) NOT NULL COMMENT 'Last Name',
   Description Varchar(1200) NOT NULL COMMENT 'Description',
   Primary Key (Id)
);

/**
 * Pictures table
 */
CREATE TABLE IF NOT EXISTS Picture (
   Id INT NOT NULL AUTO_INCREMENT COMMENT 'Picture ID',
   User_Id INT NOT NULL COMMENT 'User ID',
   Filename Varchar(120) NOT NULL COMMENT 'Image filename',
   Title Varchar(40) NULL COMMENT 'Image title',
   Alt Varchar(40) NULL COMMENT 'Alternative text',
   Primary Key (Id)
);

/**
 * Contact table
 */
CREATE TABLE IF NOT EXISTS Contact (
   User_Id INT NOT NULL COMMENT 'User ID',
   Cellphone Varchar(10) NULL,
   Country_Code Varchar(3) NULL,
   State_Code Varchar(3) NULL,
   State Varchar(40) NULL,
   City Varchar(60) NULL,
   Address Varchar(120) NULL,
   Primary Key (User_Id)
);

/**
 * Curriculum table
 */
CREATE TABLE IF NOT EXISTS Curriculum (
   Id INT NOT NULL AUTO_INCREMENT COMMENT 'Curriculum ID',
   User_Id INT NOT NULL COMMENT 'User ID',
   Summary Varchar(300) NULL COMMENT 'Summary',
   Last_Update TIMESTAMP NOT NULL COMMENT 'Last update date',
   Primary Key (Id)
);

CREATE TABLE IF NOT EXISTS Personal_Data (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Nacionality VARCHAR(30) NOT NULL COMMENT 'Nacionality',
   Relationship VARCHAR(16) NOT NULL COMMENT 'Relationship',
   Address Varchar(80) NULL COMMENT 'Address',
   Email Varchar(60) NULL COMMENT 'E-mail',
   Phone Varchar(18) NULL COMMENT 'Telephone',
   Birth_Date DATE NOT NULL COMMENT 'Date of birth',
   Primary Key (Cv_Id)
);

CREATE TABLE IF NOT EXISTS Objective (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Sequence INT NOT NULL COMMENT 'Sequence',
   Objective Varchar(120) NOT NULL COMMENT 'Objective',
   Primary Key (Cv_Id, Sequence)
);

CREATE TABLE IF NOT EXISTS Formation (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Sequence INT NOT NULL COMMENT 'Sequence',
   Name Varchar(80) NOT NULL COMMENT 'Formation',
   School Varchar(80) NOT NULL COMMENT 'School',
   Initial_Date DATE NOT NULL COMMENT 'Initial Date',
   Final_Date DATE NULL COMMENT 'Conclusion Date',
   Primary Key (Cv_Id, Sequence)
);

CREATE TABLE IF NOT EXISTS Course (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Sequence INT NOT NULL COMMENT 'Sequence',
   Name Varchar(80) NOT NULL COMMENT 'Course',
   School Varchar(80) NOT NULL COMMENT 'School',
   Duration INT NOT NULL COMMENT 'Duration in hours',
   Expiration_Date DATE NULL COMMENT 'Expiration Date',
   Primary Key (Cv_Id, Sequence)
);

CREATE TABLE IF NOT EXISTS Language (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Language Varchar(24) NOT NULL COMMENT 'Language',
   Level INT NOT NULL COMMENT 'Level',
   Primary Key (Cv_Id, Language)
);

CREATE TABLE IF NOT EXISTS Experience (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Experience_Id INT NOT NULL COMMENT 'Experience ID',
   Job_Role Varchar(50) NOT NULL COMMENT 'Job Role',
   Company Varchar(40) NOT NULL COMMENT 'Company',
   Initial_Date DATE NOT NULL COMMENT 'Initial Date',
   Final_Date DATE NULL COMMENT 'Conclusion Date',
   Primary Key (Cv_Id, Experience_Id)
);

CREATE TABLE IF NOT EXISTS Experience_Activity (
   Cv_Id INT NOT NULL COMMENT 'Curriculum ID',
   Experience_Id INT NOT NULL COMMENT 'Experience ID',
   Sequence INT NOT NULL COMMENT 'Sequence',
   Activity Varchar(90) NOT NULL COMMENT 'Activity',
   Primary Key (Cv_Id, Experience_Id, Sequence)
);

/**
 * Skills Table
 */
CREATE TABLE IF NOT EXISTS Skill (
   User_Id INT NOT NULL COMMENT 'User ID',
   Head_Skill_Id INT NOT NULL COMMENT 'First Skill ID',
   Primary Key (User_Id, Head_Skill_Id)
);

CREATE TABLE IF NOT EXISTS Skill_Item (
   User_Id INT NOT NULL COMMENT 'User ID',
   Skill_Id INT NOT NULL AUTO_INCREMENT COMMENT 'Skill ID',
   Parent_Skill_Id INT NULL COMMENT 'Parent Skill ID',
   Name Varchar(32) NOT NULL COMMENT 'Skill Name',
   Description Varchar(60) NULL COMMENT 'Skill Description',
   Primary Key (Skill_Id)
);

INSERT INTO User (User, Pass, Email, First_Name, Last_Name, Description)
VALUES
('joaovperin', 'joaovperin', 'joao@email.com', 'João', 'Perin', 'Lorem ipsum per diam accumsan risus torquent pretium ullamcorper accumsan, lorem nibh feugiat per ut nisi vulputate luctus pulvinar, primis feugiat aliquam faucibus lacus curae eros nibh. praesent morbi mollis nam, sociosqu.'),
('mathpmelo', 'mathpmelo', 'math@email.com', 'Matheus', 'Melo', 'Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum');

INSERT INTO Picture (User_Id, Filename, Title, Alt)
VALUES
('1', 'cat.jpeg', 'Cat Image', '--cat--img-xD-'), ('2', 'dog.jpg', null, null);

INSERT INTO Contact (User_Id, State, City)
VALUES
('1', 'RS', 'Novo Hamburgo'), ('2', 'RS', 'Estância Velha');

INSERT INTO Curriculum (Id, User_ID, Summary, Last_Update)
VALUES
(1, 1, 'hehe', '2018-06-17 15:30:20');

INSERT INTO Personal_Data (Cv_Id, Nacionality, Relationship, Address, Email, Phone, Birth_Date)
VALUES
(1, 'Brazilian', 'Single', 'Rua tal e blablabla - canudos', 'joao@email.com', '+55 (51) 99554422', '1996-12-10');

INSERT INTO Objective (Cv_Id, Sequence, Objective)
VALUES
(1, 1, 'Be rich'),  (1, 2, 'Become a God');

INSERT INTO Formation
(Cv_Id, Sequence, Name, School, Initial_Date, Final_Date) VALUES
(1, 1, 'Electronics technician', 'Fundação Escola Técnica Liberato Salzano Vieira da Cunha', '2011-02-21', '2016-12-21'),
(1, 2, 'Computer Science', 'Universidade Feevale', '2016-06-18', null);

INSERT INTO Course
(Cv_Id, Sequence, Name, School, Expiration_Date, Duration) VALUES
(1, 1, 'Web Designer', 'Scheffer Informática NH', null, 60);

INSERT INTO Language
(Cv_Id, Language, Level) VALUES
(1, 'Portuguese', 1), (1, 'English', 3);

INSERT INTO Experience
(Cv_Id, Experience_Id, Job_Role, Company, Initial_Date, Final_Date) VALUES
(1, 1, 'Programmer Intern', 'Rech Informática', '2016-01-18', '2017-08-17'),
(1, 2, 'Programmer', 'Rech Informática', '2017-08-18', null);

INSERT INTO Experience_Activity
(Cv_Id, Experience_Id, Sequence, Activity) VALUES
(1, 1, 1, 'Study Cobol'), (1, 1, 2, 'Study Java'), (1, 2, 1, 'Program Java');

INSERT INTO Skill_Item
(User_Id, Skill_Id , Parent_Skill_Id, Name , Description) VALUES
(1, 1, null, 'Backend Development', null),
(1, 2, 1, 'Java', null),
(1, 3, 2, 'WebServices', null),
(1, 4, 3, 'VRaptor', null),
(1, 5, 3, 'Spring Framework', null),
(1, 6, 5, 'Spring Boot', null),
(1, 7, 5, 'Spring Web MVC', null),
(1, 8, 2, 'Graphical Interface', null),
(1, 9, 8, 'Swing', null),
(1, 10, 8, 'Java FX', null),
(1, 11, null, 'Frontend Development', null),
(1, 12, 11, 'HTML5', null),
(1, 13, 11, 'CSS', null),
(1, 14, 13, 'Bootstrap', null),
(1, 15, 13, 'Ionic Framework', null),
(1, 16, 11, 'Javascript', null),
(1, 17, 16, 'jQuery', null),
(1, 18, 16, 'AngularJS', null),
(1, 19, null, 'Project Management', null),
(1, 20, 19, 'Scrum Master', null),
(1, 21, 19, 'Product Owner', null);

INSERT INTO Skill
(User_Id , Head_Skill_Id) VALUES
(1, 1), (1, 10), (1, 17);