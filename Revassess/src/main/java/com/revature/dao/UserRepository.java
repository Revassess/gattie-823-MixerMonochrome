package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import com.revature.config.ConnectionUtil;
import com.revature.model.User;

public class UserRepository implements CrudRepository<User>{
	ConnectionUtil cu = ConnectionUtil.getInstance();

	@Override
	public User save(User u){
		try(Connection conn = cu.connect()){
			String sql = "Insert into app_users(username, password, first_name, last_name, role_id) VALUES " +
					"(?,?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++,u.getUsername());
			statement.setString(i++, u.getPassword());
			statement.setString(i++, u.getFirstName());
			statement.setString(i++, u.getLastName());
			statement.setInt(i++, u.getRole().getRoleId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Set findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}