public class View {
	private Presenter presenter;

	public View() {
		// createUI();
	}

	private void createUI() {
		presenter.login("password");
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		createUI();
	}

	public void updateStatusLabel(String text) {
		System.out.println(text);
	}
}