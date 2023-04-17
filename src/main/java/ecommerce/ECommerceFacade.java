package ecommerce;

public class ECommerceFacade {
	
	private final OrderController orderController = new OrderController();
	
	private final AdvertisementController advertisementController = new AdvertisementController();
	
	private final ShippingController shippingController = new ShippingController();
	
	public ECommerceFacade() {
	
	
	}
	
	
	public ShippingController getShippingController() {
		return shippingController;
	}
	
	public void processOrder(Order order) {
		getOrderController().processOrder(order);
	}
	
	public void processOrder(Order order, String phoneNumber) {
		getOrderController().processOrder(order, phoneNumber);
	}
	
	public void playAdvertisement(int ageRestriction) {
		getAdvertisementController().playAdvertisement(ageRestriction);
	}
	
	public Order retrieveLatestOrder(int id) {
		return getOrderController().retrieveLatestOrder(id);
	}
	
	public void shipOrder(Order order, String address) {
		
		
		order.setShipping(getShippingController().createShipping(address));
		getShippingController().shipOrder(order);
		
		
	}
	
	
	public AdvertisementController getAdvertisementController() {
		return advertisementController;
	}
	
	public OrderController getOrderController() {
		return orderController;
	}
}