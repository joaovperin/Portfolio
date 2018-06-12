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

INSERT INTO User (User, Pass, Email, First_Name, Last_Name, Description)
VALUES
('joaovperin', 'joaovperin', 'joao@email.com', 'João', 'Perin', 'Lorem ipsum per diam accumsan risus torquent pretium ullamcorper accumsan, lorem nibh feugiat per ut nisi vulputate luctus pulvinar, primis feugiat aliquam faucibus lacus curae eros nibh. praesent morbi mollis nam, sociosqu.'),
('mathpmelo', 'mathpmelo', 'math@email.com', 'Matheus', 'Melo', 'Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tempus molestie, porttitor ut, iaculis quis, sem. Phasellus rhoncus. Aenean id metus id velit ullamcorper pulvinar. Vestibulum fermentum tortor id mi. Pellentesque ipsum');

INSERT INTO Picture (User_Id, Filename, Title, Alt)
VALUES
('1', 'cat.jpeg', 'Cat Image', '--cat--img-xD-'),
('2', 'dog.jpg', null, null);

INSERT INTO Contact (User_Id, State, City)
VALUES
('1', 'RS', 'Novo Hamburgo'),
('2', 'RS', 'Estância Velha');