package edu.srh.bikehire.validator;

import edu.srh.bikehire.dto.InvoiceDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.util.Util;

public class InvoiceValidator {

	private InvoiceDTO mInvoice;

	public InvoiceValidator(InvoiceDTO pInvoice) {
		mInvoice = pInvoice;
	}

	public void validateInvoice() throws BikeHireSystemException {
		if (mInvoice == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		validateInvoiceID();
		
		if (Util.isEmptyOrNullString(mInvoice.getOrderID())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		if (mInvoice.getCreationTimeStamp() == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

		// Not validation for Final Amount, Return Deposit and Damage Charges

		if (mInvoice.getWarehouseID() == null) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}
	}

	public void validateInvoiceID() throws BikeHireSystemException {

		if (Util.isEmptyOrNullString(mInvoice.getInvoiceID())) {
			// TODO:Resolve
			throw new BikeHireSystemException(-1);
		}

	}
}
