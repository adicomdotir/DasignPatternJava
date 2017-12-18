package ir.javacup.shop;

public class Main {
	public static void main(String[] args) {
		OrderFunctionUtilImpl func = new OrderFunctionUtilImpl();
		Order order = new Order();
		order.setPrice(11_000_000);
		order.setState(OrderState.READY_TO_SEND);
		System.out.println(func.isBigOrder().apply(order));
		Product p = new Product();
		// p.setState(ProductState.UNAVAILABLE);
		order.product(new Product()).product(p);
		System.out.println(func.hasMultipleProducts().apply(order));
		System.out.println(func.hasUnavailableProduct().apply(order));
		System.out.println(func.isReadyToDeliver().apply(order));
	}
}