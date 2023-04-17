package store;

import ecommerce.*;

public class Cinema {
	
	private static int count = 1;
	private final String address;
	private final String name;
	private final int id;
//	private final OrderController orderController;
//	private final ShippingController shippingController;
//	private final AdvertisementController advertisementController;
	
	private ECommerceFacade eCommerceFacade;
	
	public Cinema(String address, String name) {
		this.address = address;
		this.name = name;
		this.id = generateCinemaId();
//		this.orderController = new OrderController();
//		this.shippingController = new ShippingController();
//		this.advertisementController = new AdvertisementController();
		
		this.eCommerceFacade = new ECommerceFacade();
		
	}
	
	public void startLiveStream(int ageRestriction) {
		System.out.println("Let's watch some ads at the beginning.");
		advertise(ageRestriction);
		System.out.println("The film starts. Your cinema " + name + " hopes you enjoy the movie.");
	}
	
	public void stopLiveStream(int ageRestriction) {
		System.out.println("Let's watch some more ads. ");
		advertise(ageRestriction);
		System.out.println("Have a nice evening!");
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	public void advertise(int ageRestriction) {
		eCommerceFacade.playAdvertisement(ageRestriction);
	}
	
	public void deliverPopcorn(String shippingAddress) {
		Order order = eCommerceFacade.retrieveLatestOrder(id);
		eCommerceFacade.processOrder(order);
		eCommerceFacade.shipOrder(order, address);
	}
	
	@Override
	public String toString() {
		return "Cinema " + name + ", located at " + address;
	}
	
	private static int generateCinemaId() {
		count *= 2;
		return count;
	}
	
}
