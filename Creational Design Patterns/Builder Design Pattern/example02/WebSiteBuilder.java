public class WebSiteBuilder {
	private String title;
	private boolean haveNews;
	private boolean haveImageGallery;
	private boolean haveBlog;

	public WebSiteBuilder(String title) {
		this.title = title;
	}

	public WebSiteBuilder addNews() {
		this.haveNews = true;
		return this;
	}

	public WebSiteBuilder addImageGallery() {
		this.haveImageGallery = true;
		return this;
	}

	public WebSiteBuilder addBlog() {
		this.haveBlog = true;
		return this;
	}

	public WebSite build() {
		return new WebSite(this);
	}
}