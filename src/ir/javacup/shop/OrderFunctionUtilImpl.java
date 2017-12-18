package ir.javacup.shop;

import java.util.function.Function;

public class OrderFunctionUtilImpl implements OrderFunctionUtil {
	@Override
	public Function<Order, Boolean> isBigOrder() {
		Function<Order, Boolean> res = x -> x.getPrice() >= 10_000_000;
		return res;
	}
	
	@Override
	public Function<Order, Boolean> hasMultipleProducts() {
		return x -> x.getProducts().size() > 1;
	}
	
	@Override
	public Function<Order, Boolean> hasUnavailableProduct() {
		Function<Order, Boolean> res = x -> x.getProducts().stream()
			.filter(s -> s.getState() == ProductState.UNAVAILABLE)
			.count() >= 1;
		return res;
	}
	
	@Override
	public Function<Order, Boolean> isReadyToDeliver() {
		Function<Order, Boolean> res = x -> x.getProducts().stream()
			.filter(s -> s.getState() == ProductState.UNAVAILABLE)
			.count() == 0 && x.getState() == OrderState.READY_TO_SEND;
		return res;
	}
	
	@Override
	public Function<Order, Boolean> hasPerishableProduct() {
		Function<Order, Boolean> res = x -> x.getProducts().stream()
			.filter(s -> s.getType() == ProductType.PERISHABLE)
			.count() >= 1;
		return res;
	}
	
	@Override
	public Function<Order, Boolean> hasExpensiveBreakableProduct() {
		Function<Order, Boolean> res = x -> x.getProducts().stream()
			.filter(s -> s.getType() == ProductType.BREAKABLE)
			.count() >= 1 && x.getPrice() >= 5_000_000;
		return res;
	}
}