
import java.util.Date;
import java.text.SimpleDateFormat;

public class Kunde {

    // Anfang Attribute
    private static int count = 0;
    private int ankunftsZeit;
    private boolean hatBezahlt;
    private int KNr;
    // Ende Attribute

    // Anfang Methoden
    public Kunde() {
        KNr = count;
        count++;
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String uhrzeit = sdf.format(new Date());
        ankunftsZeit = Integer.parseInt(uhrzeit);
    }
    
    public Kunde(int ankunftsZeit){
        KNr = count;
        count++;
        this.ankunftsZeit = ankunftsZeit;
    }

    public int getAnkunftsZeit() {
        return ankunftsZeit;
    }

    public boolean hatBezahlt() {
        return hatBezahlt;
    }

    public void setHatBezahlt(boolean hatBezahlt) {
        this.hatBezahlt = hatBezahlt;
    }

    public int getKNr() {
        return KNr;
    }

    public void setKNr(int KNr) {
        this.KNr = KNr;
    }
    // Ende Methoden
} // end of Kunde
