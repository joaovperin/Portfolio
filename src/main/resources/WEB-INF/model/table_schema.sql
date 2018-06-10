/**
 * Users table
 */
CREATE TABLE IF NOT EXISTS User (
   Id INT NOT NULL AUTO_INCREMENT COMMENT 'User ID',
   User Varchar(24) NOT NULL COMMENT 'Username',
   Pass Varchar(24) NOT NULL COMMENT 'Password',
   Email Varchar(80) NOT NULL COMMENT 'Email',
   First_Name Varchar(24) NOT NULL COMMENT 'First Name',
   Last_Name Varchar(60) NOT NULL COMMENT 'Last Name',
   Primary Key (Id)
);

INSERT INTO User (User, Pass, Email, First_Name, Last_Name) 
VALUES
('joaovperin', 'joaovperin', 'joao@email.com', 'João', 'Perin'),
('mathpmelo', 'mathpmelo', 'math@email.com', 'Matheus', 'Melo');