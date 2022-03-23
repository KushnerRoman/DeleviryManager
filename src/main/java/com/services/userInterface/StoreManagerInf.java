package com.services.userInterface;

import java.util.Optional;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.courierExceptions.CourierNotExistsException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.orderExceptions.OrderExistException;
import com.exceptions.orderExceptions.OrderNotExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;

public interface StoreManagerInf {

	
	/**
	 * check if the courier exists by email
	 * 
	 * @param email the string email
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean isExistsCourierByEmail(String email);

	/**
	 * check if courier exists by id
	 * 
	 * @param id the id of courier
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean isExistsCourierById(long id);
	
	/**
	 * check if the oder exists by order
	 * 
	 * @param order the order
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean isExistsOrder(Order order);
	
	/**
	 * check if delivery exists
	 * 
	 * @param delivery
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean isExistsDelivery(Delivery delivery);
	
	/**
	 * check if the order exists by id
	 * 
	 * 
	 * @param id the order id
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean isExistsOrderById(long id);
	
	/**
	 * @return Optional List of Couriers 
	 */
	public Optional<Courier> getAllCouriers();

	
	/**
	 * @return Optional List of Orders
	 */
	public Optional<Order> getAllOrders();
	
	/** add courier to DB only if not exists by email 
	 *
	 * @See {@link #isExistsCourierByEmail(String)}
	 * @param couirer courier to create
	 * @return courier
	 * @throws CourierExistsException
	 */
	public Courier addNewCourier(Courier couirer) throws CourierExistsException ;
	
	
	/**
	 * add new order to DB only if not exist 
	 * 
	 * @see {@link #isExistOrder(Order)}
	 * @param order order to create
	 * @throws OrderExistException
	 */
	
	@SuppressWarnings("javadoc")
	public Order addNewOrder(Order order) throws OrderExistException;
	
	
	/**
	 * reconstruct order to delivery and save it in DB
	 * 
	 * @param delivery
	 * @return the delivery that was created
	 * @throws DeliveryExistException
	 */
	public Delivery addNewDelivery(Delivery delivery) throws DeliveryExistException;
	
	/**
	 * edit courier only if exists
	 * 
	 *  
	 * @see {@link #isExistCourierById(long)}
	 * @param courier
	 * @throws CourierNotExistsException
	 */
	@SuppressWarnings("javadoc")
	public void editCourier(Courier courier) throws CourierNotExistsException;

	
	/**
	 * edit order only if exists
	 * 
	 * @see #isExistsOrder(Order)
	 * @param order
	 * @throws OrderNotExistException
	 */
	public void editOrder(Order order) throws OrderNotExistException;

	/**
	 * get courier by id
	 * 
	 * @param courierId the courier id
	 * @return Optional courier
	 * @throws CourierNotExistsException
	 */
	public Optional<Courier> getOneCourierById(long courierId) throws CourierNotExistsException;

	
	/**
	 * get order by id
	 * 
	 * @param orderId the order id
	 * @return Optional Order
	 * @throws OrderNotExistException
	 */
	public Optional<Order> getOneOrderById(long orderId) throws OrderNotExistException;

}
