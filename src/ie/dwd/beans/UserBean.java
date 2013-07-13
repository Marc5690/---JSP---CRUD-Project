package ie.dwd.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String username;
	private long password;
	
	public UserBean() {}
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	
	
	public UserBean (int userid, String username ,long password){
		this.userid = userid;
		this.username = username;
		this.password = password;
		
		
	}
	
	public String toString() {
		return "" + userid + "," + password +"," + username + "";
	}


}
