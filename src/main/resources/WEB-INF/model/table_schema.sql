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
   Name Varchar(50) NOT NULL COMMENT 'Skill name',
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