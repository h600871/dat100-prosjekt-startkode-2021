package no.hvl.dat100.prosjekt.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import no.hvl.dat100.prosjekt.kontroll.spill.Kontroll;

public class BesteAvNSpill {

    public BesteAvNSpill(Kontroll kontroll){
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.OFF);

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

    public static void main(String[] args) {

        // opprett kontroll delen
        final Kontroll kontroll = new Kontroll();

        // start utsyn (Swing grensesnitt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BesteAvNSpill(kontroll);
            }
        });
    }
}
