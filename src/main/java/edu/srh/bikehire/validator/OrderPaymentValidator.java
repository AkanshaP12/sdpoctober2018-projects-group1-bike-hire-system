package edu.srh.bikehire.validator;

import edu.srh.bikehire.dto.OrderPaymentDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class OrderPaymentValidator {

	private OrderPaymentDTO mOrderPayment;

	public OrderPaymentValidator(OrderPaymentDTO pOrderPayment) {
		mOrderPayment = pOrderPayment;
	}

	public void validateOrderPayment() throws BikeHireSystemException {
		if (mOrderPayment == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		validateOrderPaymentReference();
		
		if (Util.isEmptyOrNullString(mOrderPayment.getOrderID())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		if (mOrderPayment.getDepositAmount() <= 0) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		if (mOrderPayment.getRentPerDay() <= 0) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		if (mOrderPayment.getRentPerHour() <= 0) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

	}

	public void validateOrderPaymentReference() throws BikeHireSystemException {
		if (Util.isEmptyOrNullString(mOrderPayment.getPaymentReference())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
	}
}
