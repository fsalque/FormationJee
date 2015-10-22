package org.exemple.user.entities;

public class User implements IUser {
	private int id;
	private String name ;
	private String surname;
	private String adress;
	
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#getSurname()
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#setSurname(java.lang.String)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#getAdress()
	 */
	@Override
	public String getAdress() {
		return adress;
	}
	/* (non-Javadoc)
	 * @see org.exemple.user.entities.IUser#setAdress(java.lang.String)
	 */
	@Override
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
