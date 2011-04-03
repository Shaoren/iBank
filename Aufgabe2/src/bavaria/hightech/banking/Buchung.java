package bavaria.hightech.banking;

//immutable kann den zustand nicht mehr ändern FINAL bzw die klasse kann nicht abgeleitet werden
// zum beispiel string QQ
public final class Buchung {

	private final String text;
	private final float betrag; // buchung kann nie mehr geändert werden

	public Buchung(float betrag, String text) {
		this.betrag = betrag;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public float getBetrag() {
		return betrag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buchung[");
		builder.append("Betrag: ").append(betrag);
		builder.append(";");
		builder.append("Grund: ").append(text);
		builder.append("]");
		return builder.toString();
	}
}
