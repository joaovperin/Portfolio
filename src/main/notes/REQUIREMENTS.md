PORTFOLIO.

This application is planned to be a live web page that will help every programmer to show their personal projects, so it will act like a Programmer's Portfolio.
And, for sure, it would also be mine.

So let's go to the requirements:


-- FUNCTIONAL --

#1 A page with the curriculum.
   - The centered picture of the portfolio's owner
   - A briefly presentation text
   - Some curriculum thing, like experiencie, areas of interest, etc.
   - Capabilities

#2 A page to show personal projects
   - Graphic components with the less specific capabilities that when clicked should spawn more specifical ones. Example:

Backend Development
   Java
     WebServices
       VRaptor
       Spring Framework
         Spring Boot
         Spring MVC
     Graphical Interface
       Swing
       JavaFX
Frontend Development
   HTML5
   CSS
     Bootstrap
   Javascript
     jQuery
     React
Project Management
  Product Owner
  Scrum Master

#3 A contact page
   - The owner's name and email
   - Social Media, cellphone, whatever you would to put here.

#4 A maintenance page
   - Every owner has to have a login and password to manage their portfolio
   - They will just have access to the UI.

-- DESIGN IDEAS --
   - The first page would be curriculum. I though in a bottom navbar with 3 buttons, being the middle one a link to the curriculum.
   - It also has to be a top bar with some info and a button to Login and/or Logout.
   - The login is intended for the owners, so it have to open the maintenance page.

-- NOT FUNCTIONAL REQUISITES --

  - Development Ones
#1 In-memory high performance database (like HSQLDB)
#2 A built-in server (I think Spring Boot will do it)
#3 Object-Relational Mapping (Spring JPA)
#4 Easy data-source configuration (via Properties files)
#5 Internationalization (i18n)
#6 A good view motor that supports easy and understandable code and helps us (Thymeleaf)
#7 A place to store static files (pictures and attachments)

- Production Ones (that differ from development)
#1 A robust relational database that runs on disk (like MySQL)
#2 Comming soon...
