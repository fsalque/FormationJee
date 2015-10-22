package org.exemple.user.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.exemple.connection.SqlConnection;
import org.exemple.user.entities.User;

public class UsersManager {
	
	private static final UsersManager instance= new UsersManager();
	
	private static boolean initialized = false;
	
	private UsersManager(){
	};
	
	
	public static void Initialize() {
		if (!initialized){
			for (int i = 0;i<10;i++){
				User user = new User();
				user.setAdress("Adresse"+i);
				user.setId(i);
				user.setName("Nom"+i);
				user.setSurname("Prenom"+i);
				instance.add(user);
				initialized = true;
			}
		}
	}
	
	public static final UsersManager getInstance(){
		return instance;
	}
	
	private Map<Integer,User> listUsers = new HashMap<Integer,User>();
	
	public void add(User user){
		this.listUsers.put(user.getId(),user);
	}
	
	public User remove(int i){
		return this.listUsers.remove(i);
	}
	
	public User getByID(int id){
		User result = null;
		result = listUsers.get(id);
		return result;
	}
	
	public ArrayList<User> getAll(){
		listUsers.clear();
		Statement stmt = null;
		
		try {
			stmt = SqlConnection.getInstance().getConnection().createStatement();
			ResultSet rslt = stmt.executeQuery("SELECT * From user;");
			
			while(rslt.next()){				
				int id = rslt.getInt("id");
				String name = rslt.getString("lastname");
				String surname = rslt.getString("firstname");
				String adress = rslt.getString("adress");
			
				User user = new User();
				user.setAdress(adress);
				user.setId(id);
				user.setName(name);
				user.setSurname(surname);
				
				
				listUsers.put(id, user);
			}
			rslt.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(stmt!=null){
				try {
					stmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return new ArrayList<User>(listUsers.values());
	}
	
	public void update(User user){
		listUsers.replace(user.getId(), user);
	}

}
