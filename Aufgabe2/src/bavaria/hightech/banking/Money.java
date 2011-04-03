package bavaria.hightech.banking;

public class Money {
	private long money;
	private Währungstypen währungstyp;

	public void add(Money betrag) {
		this.money += betrag.money;
	}

	public void subtract(Money betrag) {
		this.money -= betrag.money;
	}

	public boolean same(Money other) {
		if (money != other.money)
			return false;
		if (währungstyp != other.währungstyp)
			return false;
		return true;
	}

	public void biggerwhatever() {

	}
}