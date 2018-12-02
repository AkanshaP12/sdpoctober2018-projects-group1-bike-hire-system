package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.UserAccountDTO;

public interface UserAccountDAO {
	public UserAccountDTO getUserAccount(String pUserId);
	
	public boolean addUserAccount(UserAccountDTO pUserAccountDTO);
	
	public boolean updateUserAccount(UserAccountDTO pUserAccountDTO);
}
