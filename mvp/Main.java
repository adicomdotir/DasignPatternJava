public class Main {
	public static void main(String[] args) {
		View view = new View();
		Presenter p = new Presenter(view, new Model());
		view.setPresenter(p);
	}
}