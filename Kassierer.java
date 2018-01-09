
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kassierer {

    private SimpleDateFormat sdf;

    public Kassierer() {
        sdf = new SimpleDateFormat("HH");
    }

    public double kassieren(Kunde k, double Preis) {
        if (k.hatBezahlt())
            return 0;
        String uhrzeit = sdf.format(new Date());
        int Jetzt = Integer.parseInt(uhrzeit);
        double Rechnung = ((double) (k.getAnkunftsZeit() - Jetzt)) * Preis;
        k.setHatBezahlt();
        return Rechnung;
    }
}
