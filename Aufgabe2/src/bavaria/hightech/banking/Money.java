package bavaria.hightech.banking;

public class Money {
	private long money;
	private W�hrungstypen w�hrungstyp;

	public void add(Money betrag) {
		this.money += betrag.money;
	}

	public void subtract(Money betrag) {
		this.money -= betrag.money;
	}

	public boolean same(Money other) {
		if (money != other.money)
			return false;
		if (w�hrungstyp != other.w�hrungstyp)
			return false;
		return true;
	}

	public void biggerwhatever() {

	}
}