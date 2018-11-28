public class WebSite {
	private String title;
	private boolean haveNews;
	private boolean haveImageGallery;
	private boolean haveBlog;

	public WebSite(WebSiteBuilder webSiteBuilder) {
		title = webSiteBuilder.title;
		haveNews = webSiteBuilder.haveNews;
		haveImageGallery = webSiteBuilder.haveImageGallery;
		haveBlog = webSiteBuilder.haveBlog;
	}
}