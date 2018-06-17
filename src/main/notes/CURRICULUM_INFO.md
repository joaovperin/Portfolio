# Curriculum Info!

Table Structure:
- Curriculum (
   Id, UserID, Abstract, Date
)

- Personal_Data (
   Cv_Id, Nacionality, Relationship,
   Address, Email, Phone, Birth_Date
)

- Objective (
   Cv_Id, Sequence, Objective
)

- Formation (
   Cv_Id, Sequence, Name, School,
   Initial_Date, Final_Date
)

- Course (
   Cv_Id, Sequence, Name, School,
   Expiration_date, Initial_Date, Final_Date, Duration
)

- Languages (
  Cv_Id, Language, Level
)

- Experience (
   Cv_Id, Experience_Id, Job_Role, Company
   Initial_Date, Final_Date
)

- Experience_Activity (
   Cv_Id, Experience_Id, Activity
)
