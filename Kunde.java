
public class Kunde {
  
  // Anfang Attribute
    private long ankunftsZeit;
    private boolean hatBezahlt;
    private int KNr;
  // Ende Attribute
  
  // Anfang Methoden
    public long getAnkunftsZeit() {
        return ankunftsZeit;
    }

    public void setAnkunftsZeit(long ankunftsZeit) {
        this.ankunftsZeit = ankunftsZeit;
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
