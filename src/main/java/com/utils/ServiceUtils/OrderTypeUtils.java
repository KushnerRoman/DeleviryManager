package com.utils.ServiceUtils;

public enum OrderTypeUtils {
	
	DELIVERY,TAKEAWAY,PLACEDORDER;
	
	@Override
	public String toString() {
		switch (this) {
		case DELIVERY:
			return "Delivery";
		case TAKEAWAY:
			return "Take Away";
		case PLACEDORDER:
			return "Placed Order"; 


		default:
			return super.toString();
		}
	}

}
