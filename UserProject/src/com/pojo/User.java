package com.pojo;




public class User {
	
	
	protected int id;
  	protected String name;
  	protected String email;
  	protected String password;
  	public boolean valid;
	
	public User() {
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 public boolean isValid() {
         return valid;
	}
      public void setValid(boolean newValid) {
         valid = newValid;
	}
      
  	
          
}
