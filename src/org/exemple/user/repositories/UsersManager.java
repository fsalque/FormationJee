package org.exemple.user.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.exemple.connection.SqlConnection;
import org.exemple.user.entities.User;

public class UsersManager {

	private static final UsersManager instance = new UsersManager();


	private UsersManager() {
	};


	public static final UsersManager getInstance() {
		return instance;
	}


	public User add(User user) {
		User result = getByID(user.getId());
		if (result == null) {
			result = user;

			java.sql.PreparedStatement stmt = null;
			try {
				stmt = SqlConnection.getInstance().getConnection()
						.prepareStatement("INSERT INTO jee.user VALUES (?,?,?,?);");
				stmt.setInt(1,user.getId());
				stmt.setString(2,user.getName());
				stmt.setString(3,user.getSurname());
				stmt.setString(4, user.getAdress());
				
				int rslt = stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} else {
			result = null;
		}
		return result;
	}

	public User remove(int id) {
		User result = getByID(id);

		if (result != null) {
			java.sql.PreparedStatement stmt = null;
			try {
				stmt = SqlConnection.getInstance().getConnection()
						.prepareStatement("DELETE FROM user WHERE user.id=?;");
				stmt.setInt(1, id);
				int rslt = stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return result;
	}

	public User getByID(int id) {
		User result = null;
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = SqlConnection.getInstance().getConnection().prepareStatement("Select * FROM user WHERE user.id=?;");
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			if (rslt.next()) {
				int idUser = rslt.getInt("id");
				String name = rslt.getString("lastname");
				String surname = rslt.getString("firstname");
				String adress = rslt.getString("adress");

				User user = new User();
				user.setAdress(adress);
				user.setId(idUser);
				user.setName(name);
				user.setSurname(surname);

				result = user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public List<User> getAll() {
		List<User> result = new ArrayList<User>();
		Statement stmt = null;

		try {
			stmt = SqlConnection.getInstance().getConnection().createStatement();
			ResultSet rslt = stmt.executeQuery("SELECT * From user;");

			while (rslt.next()) {
				int id = rslt.getInt("id");
				String name = rslt.getString("lastname");
				String surname = rslt.getString("firstname");
				String adress = rslt.getString("adress");

				User user = new User();
				user.setAdress(adress);
				user.setId(id);
				user.setName(name);
				user.setSurname(surname);

				result.add(user);
			}
			rslt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public User update(User user) {
		User result = getByID(user.getId());
		if (result != null) {
			result = user;
			java.sql.PreparedStatement stmt = null;
			try {
				stmt = SqlConnection.getInstance().getConnection()
						.prepareStatement("UPDATE user SET firstname=?,lastname=?,adress=? WHERE `id`=?;");
				stmt.setInt(4,user.getId());
				stmt.setString(2,user.getName());
				stmt.setString(1,user.getSurname());
				stmt.setString(3, user.getAdress());
				
				int rslt = stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} 
		return result;
	}

}
