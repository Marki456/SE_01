
public class Kassierer {
    
    private Kassierer() {}
    
    public static double kassieren(Kunde k, double Preis) {
        if (k.hatBezahlt())
            return 0;
        double Rechnung = ((double) (k.getAnkunftsZeit() - Zeit.getZeit()) + 1) * Preis;
        k.setHatBezahlt();
        return Rechnung;
    }
}
