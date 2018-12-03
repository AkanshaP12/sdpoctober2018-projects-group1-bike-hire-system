package edu.srh.bikehire.dao;

import edu.srh.bikehire.dto.UserDTO;

public interface UserDAO {
	public UserDTO getUser(String pUserId);
	
	public UserDTO getUserByEmailId(String pEmailId);
	
	public String addUser(UserDTO pNewUser);
	
	public boolean updateUser(UserDTO pUser);
}
