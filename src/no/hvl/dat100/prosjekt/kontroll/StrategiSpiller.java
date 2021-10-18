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
public class StrategiSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller posisjon for spilleren (nord eller syd).
	 */
	public StrategiSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. 
	 * Strategien er å spille av fargen som allerede ligger nede først. 
	 * Hvis ikke brukes kort av samme verdi eller åttere. 
	 * 
	 * Dersom man ikke har lovlige kort å spille, trekker man om man ikke
	 * allerede har trukket maks antall ganger. I så fall sier man forbi.
	 * 
	 * @param topp kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		//finn første lovlige [0]=åtter, [1]=farge, [2]=verdi 
		Kort[] spill = new Kort[3];
		for (Kort kort : getHand().getAllekort()){
			if (Regler.kanLeggeNed(kort, topp)){
				if (spill[0] == null && Regler.atter(kort)){
					spill[0] = kort;
				}else if (spill[1] == null && kort.getFarge().equals(topp.getFarge())) {
					spill[1] = kort;
				} else if (spill[2] == null) {
					spill[2] = kort;
				} else {
					break;
				}

			}
		}

		Handling handling = null;

		if (spill[1] != null) {
			//spill samme farge
			handling = new Handling(HandlingsType.LEGGNED, spill[1]);

		} else if (spill[2] != null) {
			//spill samme verdi
			handling = new Handling(HandlingsType.LEGGNED, spill[2]);

		} else if (spill[0] != null) {
			//spill åtter
			handling = new Handling(HandlingsType.LEGGNED, spill[0]);

		} else if (getAntallTrekk() < Regler.maksTrekk()) {
			handling = new Handling(HandlingsType.TREKK, null);

		} else {
			handling = new Handling(HandlingsType.FORBI, null);
		}

		return handling;
	}
}
