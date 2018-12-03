package edu.srh.bikehire.validator;

import edu.srh.bikehire.dtointerface.OrderHistoryDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class OrderHistoryValidator {

	private OrderHistoryDTO mOrderHistory;

	public OrderHistoryValidator(OrderHistoryDTO pOrderHistory) {
		mOrderHistory = pOrderHistory;
	}

	public void validateOrderHistory() throws BikeHireSystemException {
		if (mOrderHistory == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mOrderHistory.getOrderID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		validateInvoiceID();
		
		if (Util.isEmptyOrNullString(mOrderHistory.getUserID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (Util.isEmptyOrNullString(mOrderHistory.getBikeID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

		if (mOrderHistory.getBookingTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);

		}

		if (mOrderHistory.getPickupTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);

		}

		if (mOrderHistory.getReturnedTimeStamp() == null) {
			// TODO:
			throw new BikeHireSystemException(-1);

		}

	}

	public void validateInvoiceID() throws BikeHireSystemException {
		if (Util.isEmptyOrNullString(mOrderHistory.getInvoiceID())) {
			// TODO:
			throw new BikeHireSystemException(-1);
		}

	}

}
