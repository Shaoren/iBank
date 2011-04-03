package bavaria.hightech.testit;

import bavaria.hightech.banking.konto.FestgeldKonto;
import bavaria.hightech.banking.konto.GiroKonto;

public class Test {
	/**
	 * @param args
	 * @throws Exception
	 *             zu viel geld geht vom festgeldkonto ab
	 */
	public static void main(String[] args) throws Exception {

		/** Zinsen: als Prozent-Zahl eingeben! */

		System.out.println("FestgeldKonto-Test:");

		FestgeldKonto k = new FestgeldKonto(0.5f, 12345, "Max Mustermann");
		System.out.println(k.getKontoinhaber());
		k.zugang(100, "Bankeinzahlung");
		k.zugang(700, "Finderlohn für eine vermisste Katze bekommen");
		k.verzinsen();
		k.abgang(555, "10 Paar neue Schuhe gekauft");

		System.out.println("\nGiroKonto-Test:");

		GiroKonto g = new GiroKonto(0.5f, 16, 24545643, "Mareike Mustermann");
		g.zugang(200, "Geld von Oma");
		g.verzinsen();
		g.abgang(300, "Netbook bei Promarkt gekauft");
		g.verzinsen();
	}
}
