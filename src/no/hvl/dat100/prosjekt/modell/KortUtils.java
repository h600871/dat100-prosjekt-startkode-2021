package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Collections;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {
		Kort[] kort = samling.getAllekort();
		Arrays.sort(kort);

		samling.fjernAlle();
		for (Kort k : kort)
			samling.leggTil(k);
	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {
		Collections.shuffle(Arrays.asList(samling.getAllekort()));
	}

}
