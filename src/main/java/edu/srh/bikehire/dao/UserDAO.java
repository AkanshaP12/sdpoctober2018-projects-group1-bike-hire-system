package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.UserDTO;

public interface UserDAO {
	public UserDTO getUser(String pUserId);
	
	public String addUser(UserDTO pNewUser);
	
	public boolean updateUser(UserDTO pUser);
}
