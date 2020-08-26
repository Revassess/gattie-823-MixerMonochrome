Select * from APP_USER Where
  role_id in (Select role_id from USER_ROLE Where
  			name = 'BASIC_USER');