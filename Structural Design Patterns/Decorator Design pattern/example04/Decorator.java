public class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public String getInfo() {
		String info = component.getInfo();
		return info.toUpperCase();
	}
}