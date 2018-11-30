public class Factory {
	public Product getProduct(int id) {
		if (id == 1) {
			return new ProductA();
		} else {
			return new ProductB();
		}
	}
}
