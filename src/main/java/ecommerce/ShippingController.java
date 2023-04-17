package ecommerce;

public class ShippingController {
	
	public void shipOrder(Order order) {
		System.out.println("Shipping of order " + order.getId() + " to " + order.getShipping().getAddress() + " has "
				                   + "been successful. The estimated delivery date is: " + order.getDeliveryDate());
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	public Shipping createShipping(String address) {
		return new Shipping(address);
	}
	
	public void commissionExternalParcelService() {
		System.out.println("Commission external parcel service due to high shipping demand.");
	}
	
}