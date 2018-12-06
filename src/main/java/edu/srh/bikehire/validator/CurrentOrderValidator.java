package edu.srh.bikehire.validator;

import edu.srh.bikehire.dto.CurrentOrderDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class CurrentOrderValidator {

	private CurrentOrderDTO mCurrentOrder;

	public CurrentOrderValidator(CurrentOrderDTO pCurrentOrder) {
		mCurrentOrder = pCurrentOrder;
	}

	public void validateCurrentOrder() throws BikeHireSystemException {
		if (mCurrentOrder == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		validateCurrentOrderID();

		if (Util.isEmptyOrNullString(mCurrentOrder.getUserID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mCurrentOrder.getBikeID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (mCurrentOrder.getBookingTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (mCurrentOrder.getPickupTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (mCurrentOrder.getDropOffTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (mCurrentOrder.getActualDropOffTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mCurrentOrder.getOrderMode())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

	}

	public void validateCurrentOrderID() throws BikeHireSystemException {

		if (Util.isEmptyOrNullString(mCurrentOrder.getOrderID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}
	}

}
