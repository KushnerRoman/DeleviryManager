package com.utils.modelUtils;

/*
 *  {@code enum} the Enum contain all the Orders type entities that exist in the application;
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

public enum OrderEntityUtils {


	TAKEAWAY,DELIVERY;
	
	@Override
	public String toString() {
		switch (this) {
		case TAKEAWAY:
			return "Take Away";
		case DELIVERY:
			return "Delivery";
		default:
			return super.toString();
		}
	}
	
	
	
}
