public class FishingBoatAdapter implements RowingBoat {

	// private static final Logger LOGGER = LoggerFactory.getLogger(FishingBoatAdapter.class);

	private FishingBoat boat;

	public FishingBoatAdapter() {
		boat = new FishingBoat();
	}

	@Override
	public void row() {
		boat.sail();
	}
}