public class Main {
	public static void main(String[] args) {
		View view = new View();
		view.setPresenter(new Presenter(view, new Model()));
	}
}