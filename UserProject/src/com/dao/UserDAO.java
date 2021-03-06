package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;



public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/basic";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	private static final String INSERT_USERS_SQL = "Insert into users" + "  (name, email, password) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,password from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, password =? where id = ?;";
	private static final String LOGIN_USER = "select * from users where email=? AND password=?";
	
	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public User loginUser(String email,String password) {
		    User user = null;
		    try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER);) {
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
		         boolean more = rs.next();
		         if (!more) 
		         {
		            System.out.println("welcome .......login");
		            user = new User();
		            user.setValid(false);
		         }  
		         else if (more) 
		         {
		            String email2 = rs.getString("email");
		            String password2 = rs.getString("password");
		            System.out.println("Bemvindo " + email2);
		            user = new User(email2, password2);
		            user.setValid(true);
		         }
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public void insertUser(User user) throws SQLException {
		try (Connection connection = getConnection();
						
		    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			
			
			System.out.println("value inserted in inser user dao");
			
			preparedStatement.setString(1, user.getName());			
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(id, name, email, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				users.add(new User(id, name, email, password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
}
