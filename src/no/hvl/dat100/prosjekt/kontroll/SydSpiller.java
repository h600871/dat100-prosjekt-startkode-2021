package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for å representere en vriåtter syd-spiller. Strategien er å lete
 * gjennom kortene man har på hand og spille det første som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller posisjon for spilleren (nord eller syd).
	 */
	public SydSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. Strategien er å spille det første kortet
	 * som er lovlig (også en åtter selv om man har andre kort som også kan
	 * spilles). Dersom man ikke har lovlige kort å spille, trekker man om man ikke
	 * allerede har trukket maks antall ganger. I så fall sier man forbi.
	 * 
	 * @param topp kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		//finn første lovlige kort
		Kort spill = null;
		for (Kort kort : getHand().getAllekort()){
			if (Regler.kanLeggeNed(kort, topp)){
				spill = kort;
			}
		}

		Handling handling = null;

		if (spill != null) {
			handling = new Handling(HandlingsType.LEGGNED, spill);
		} else if (getAntallTrekk() < Regler.maksTrekk()) {
			handling = new Handling(HandlingsType.TREKK, null);
		} else {
			handling = new Handling(HandlingsType.FORBI, null);
		}

		return handling;
	}
}
