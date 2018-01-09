
public class Einnahme {
    private long timestamp;
    private double betrag;

    public Einnahme(long timestamp, double betrag) {
        this.timestamp = timestamp;
        this.betrag = betrag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getBetrag() {
        return betrag;
    }
    
}
