Select * from (Select * from APP_USER, STUDY_SET Where STUDY_SET.owner_id = APP_USER.user_id) as appStud 
Where user_id = 5;