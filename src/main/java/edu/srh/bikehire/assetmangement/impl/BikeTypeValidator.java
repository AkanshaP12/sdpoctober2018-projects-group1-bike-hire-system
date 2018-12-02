package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.assetmangement.BikeType;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeTypeValidator {
private BikeType mBikeType;

public BikeTypeValidator(BikeType pBikeType) {
	mBikeType = pBikeType;
}

public void validateAddBikeType() throws BikeHireSystemException
{
	if(mBikeType == null)
	{
		//TODO:Resolve
		throw new BikeHireSystemException(-1);
	}
	
	if(Util.isEmptyOrNullString(mBikeType.BikeTypeID()))
	{
		//TODO:Resolve
		throw new BikeHireSystemException(-1);
	}
	
	if(Util.isEmptyOrNullString(mBikeType.Type()))
	{
		//TODO:
		throw new BikeHireSystemException(-1);
	}
	
	if(Util.isEmptyOrNullString(mBikeType.getBikeAgeCategory()))
	{
		//TODO:Resolve
		throw new BikeHireSystemException(-1);
	
	}
	//TODO:OTHER BIKETYPE EXCEPTIONS
	

    }

}
