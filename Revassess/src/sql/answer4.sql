
Select username, category.name, flashcard.question, flashcard.answer from 
app_user inner join study_set ON (study_set.owner_id = app_user.user_id) 
inner join study_set_card ON (study_set_card.study_set_id = study_set.study_set_id) 
inner join flashcard ON (flashcard.flashcard_id = study_set_card.flashcard_id) 
inner join category ON (category.category_id = flashcard.category_id) 
Where app_user.user_id = 5;