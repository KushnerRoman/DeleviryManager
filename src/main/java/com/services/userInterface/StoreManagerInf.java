package com.services.userInterface;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.courierExceptions.CourierNotExistsException;
import com.exceptions.deliveryExceptions.DeliveryNotExistException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.orderExceptions.OrderNotExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;


public interface StoreManagerInf {

	
	/**
	 * check if the courier exists by login
	 * 
	 * @param login the string login
	 * @return true if exist else false
	 * @author RomanHP
	 */
	boolean existsCourierByLogin(String email);

	/**
	 * check if courier exists by id
	 * 
	 * @param id the id of courier
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean existsCourierById(Long id);
	
	/**
	 * check if user exists by id
	 * 
	 * @param id the id of user
	 * @return true if exist 
	 * @author RomanHP
	 */
	public boolean existsUser(Long id);
	
	

	/**
	 * check if delivery exists
	 * 
	 * @param delivery
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean existsDelivery(Delivery delivery);
	
	/**
	 * check if the order exists by id
	 * 
	 * 
	 * @param id the order id
	 * @return true if exist else false
	 * @author RomanHP
	 */
	public boolean existsDeliveryById(Long id);
	
	/**
	 * @return Optional List of Couriers 
	 */
	public List<Delivery> getAllCouriers();

	
	/**
	 * @return Optional List of Orders
	 */
	public Optional<List<Delivery>> getAllDeliveries();
	
	/** add courier to DB only if not exists by email 
	 *
	 * @See {@link #isExistsCourierByEmail(String)}
	 * @param couirer courier to create
	 * @return courier
	 * @throws CourierExistsException
	 */
	public Courier addNewCourier(Courier couirer) throws CourierExistsException ;
	
	
	
	/**
	 * create new delivery if time not passed 5 minutes and save it in DB
	 * 
	 * @see{@link #getTodayLastOrder}
	 * @param delivery
	 * @return the delivery that was created
	 * @throws DeliveryExistException
	 * @throws DeliveryNotExistException 
	 */
	public Delivery addNewDelivery(Delivery delivery) throws DeliveryExistException;
	
	/**
	 * edit courier only if exists
	 * 
	 *  
	 * @see {@link #isExistCourierById(Long)}
	 * @param courier
	 * @throws CourierNotExistsException
	 */

	public void editCourier(Courier courier) throws CourierNotExistsException;

	
	/**
	 * edit order only if exists
	 * 
	 * @see #isExistsOrder(Order)
	 * @param order
	 * @throws OrderNotExistException
	 */
	public void editDelivery(Order order) throws OrderNotExistException;

	/**
	 * get courier by id
	 * 
	 * @param courierId the courier id
	 * @return Optional courier
	 * @throws CourierNotExistsException
	 */
	public Optional<Courier> getOneCourierById(Long courierId) throws CourierNotExistsException;

	
	/**
	 * get order by id
	 * 
	 * @param orderId the order id
	 * @return Optional Order
	 * @throws OrderNotExistException
	 */
	public Optional<Order> getOneDeliveryById(Long orderId) throws OrderNotExistException;
	
	/**
	 * get the last time  order that made today
	 * 
	 * @param date
	 * @param phoneNumber
	 * @return Last time order
	 * @throws DeliveryNotExistException
	 */
	public Time getTodayLastOrder(String phoneNumber) throws DeliveryNotExistException;

	

}
