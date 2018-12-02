package edu.srh.bikehire.assetmangement.impl;

import edu.srh.bikehire.dtointerface.BikeTypeDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class BikeTypeValidator {
	private BikeTypeDTO mBikeType;

	public BikeTypeValidator(BikeTypeDTO pBikeType) {
		mBikeType = pBikeType;
	}

	public void validateAddBikeType() throws BikeHireSystemException {
		if (mBikeType == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

//		if (Util.isEmptyOrNullString(mBikeType.getBikeTypeId())) {
//			// TODO:Resolve
//			throw new BikeHireSystemException(-1);
//		}

		if (Util.isEmptyOrNullString(mBikeType.getBikeType())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mBikeType.getAgeCategory())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);

		}
		// TODO:OTHER BIKETYPE EXCEPTIONS

	}

}
