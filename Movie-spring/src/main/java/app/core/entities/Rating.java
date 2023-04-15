package app.core.entities;

public enum Rating {
	ONE_STAR, TWO_STARS, THREE_STARS, FOUR_STARS, FIVE_STARS;

	public static int getRatingNumbers(Rating rating) {
		return rating.ordinal() + 1;
	}
}
