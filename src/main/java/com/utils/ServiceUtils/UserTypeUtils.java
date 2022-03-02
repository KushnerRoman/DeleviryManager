package com.utils.ServiceUtils;

public enum UserTypeUtils {
	COURIER,CUSTOEMR,SHIFT_MANAGER,STORE_MANAGER;
	
	@Override
	public String toString() {
		switch (this) {
		case COURIER:
			return "Courier";
		case CUSTOEMR:
			return "Customer";
		case SHIFT_MANAGER:
			return "Shift Manager"; 
		case STORE_MANAGER:
			return "Store Manager";

		default:
			return super.toString();
		}
	}

}
