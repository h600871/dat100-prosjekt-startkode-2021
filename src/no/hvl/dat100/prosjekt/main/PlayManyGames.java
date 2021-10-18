package no.hvl.dat100.prosjekt.main;

import javax.swing.SwingUtilities;

import no.hvl.dat100.prosjekt.kontroll.spill.Kontroll;
import no.hvl.dat100.prosjekt.utsyn.*;

public class PlayManyGames {

    public static void main(String[] args) {

        // opprett kontroll delen
        final Kontroll kontroll = new Kontroll();

        // start utsyn (Swing grensesnitt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                int nordSpillerVunnet = 0;
                int sydSpillerVunnet = 0;
                int antallSpill = 1000;

                for (int i = 0; i < antallSpill; i++) {

                    kontroll.startSpill();
                    kontroll.spillAuto();
                    switch (kontroll.vinner()) {
                        case INGEN:
                            break;
                        case NORD:
                            nordSpillerVunnet++;
                            break;
                        case SYD:
                            sydSpillerVunnet++;
                            break;
                    }
                }

                System.out.printf("%nNordSpiller har vunnet %d / %d%nSydSpiller har vunnet %d / %d", nordSpillerVunnet, antallSpill, sydSpillerVunnet, antallSpill);
            }
        });
    }
}
