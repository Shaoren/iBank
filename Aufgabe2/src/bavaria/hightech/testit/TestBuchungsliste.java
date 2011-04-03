package bavaria.hightech.testit;

import bavaria.hightech.banking.Buchung;
import bavaria.hightech.banking.Buchungsliste;

public class TestBuchungsliste {
	public static void main(String[] args) {
		Buchungsliste hass = new Buchungsliste();
		hass.add(new Buchung(99999, "Gewinn!"));
		hass.add(new Buchung(1, "Auf der Straﬂe gefunden"));
		System.out.println(hass.next());
		hass.clear();
	}
}
