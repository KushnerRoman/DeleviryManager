package com.utils.modelUtils;

/*
 *  {@code enum} the Enum contain all the uder type entities that exist in the application;
 * 
 * <p>
 * <li>The method {@code toString} should be used after specifying which
 * information is wanted, in order to get the corresponding information (if used
 * for a string and not for the type).</li>
 * <p>
 * 
 * @author Roman Kushner
 * 
 * */

public enum UserEnityUtils {
	
	COURIER,CUSTOMER,SHIFT_MANAGER,STORE_MANAGER,LOGGER;

	
	
	@Override
	public String toString() {
		switch(this) {
		case COURIER:
			return "Courier";
		case CUSTOMER :
			return "Customer";
		case SHIFT_MANAGER :
			return "Shift Manager";
		case STORE_MANAGER :
			return "Store Manager";
		case LOGGER:
			return "Logger";
		default :
			return super.toString();
		}
		
	}

}
