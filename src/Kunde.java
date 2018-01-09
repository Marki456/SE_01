
import java.util.Date;
import java.text.SimpleDateFormat;

public class Kunde {

    // Anfang Attribute
    private static int count = 0;
    private int ankunftsZeit;
    private boolean hatBezahlt;
    private int KNr;
    private boolean parkt;
    private boolean notfall;
    // Ende Attribute

    // Anfang Methoden
    public Kunde() {
        KNr = count;
        count++;
        parkt = true;
        notfall = false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String uhrzeit = sdf.format(new Date());
        ankunftsZeit = Integer.parseInt(uhrzeit);
    }
    
    public Kunde(int ankunftsZeit){
        KNr = count;
        count++;
        parkt = true;
        notfall = false;
        this.ankunftsZeit = ankunftsZeit;
    }

    @Override
    public String toString() {
        String hatbez = hatBezahlt? "ja    " : "nein";
        String hatver = parkt? "nein" : "ja    ";
        String hatnf = notfall? "ja    " : "nein";
        return String.format("%s %02d \t %s %02d %s \t %s %s \t %s %s \t %s %s", "Kunde", KNr, "Ankunftszeit:", ankunftsZeit, "Uhr", "Hat bezahlt:", hatbez, "Hat Notfall:", hatnf, "Hat verlassen:", hatver);
    }

    public int getAnkunftsZeit() {
        return ankunftsZeit;
    }

    public boolean hatBezahlt() {
        return hatBezahlt;
    }

    public void setHatBezahlt() {
        this.hatBezahlt = true;
    }

    public int getKNr() {
        return KNr;
    }

    public void setKNr(int KNr) {
        this.KNr = KNr;
    }
    
    public void verlassen() {
        parkt = false;
    }
    
    public boolean istParkt() {
        return parkt;
    }

    public void notfall() {
        notfall = true;
    }

    public boolean isNotfall() {
        return notfall;
    }
    // Ende Methoden

} // end of Kunde