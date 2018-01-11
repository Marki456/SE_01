
public class Einnahme {
    private int timestamp;
    private double betrag;

    public Einnahme(int timestamp, double betrag) {
        this.timestamp = timestamp;
        this.betrag = betrag;
    }
    public Einnahme(double betrag) {
        this.timestamp = Zeit.getZeit();
        
        this.betrag = betrag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getBetrag() {
        return betrag;
    }
    
}
