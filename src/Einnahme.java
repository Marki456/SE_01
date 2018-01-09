import java.text.SimpleDateFormat;
import java.util.Date;

public class Einnahme {
    private int timestamp;
    private double betrag;

    public Einnahme(int timestamp, double betrag) {
        this.timestamp = timestamp;
        this.betrag = betrag;
    }
    public Einnahme(double betrag) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String uhrzeit = sdf.format(new Date());
        this.timestamp = Integer.parseInt(uhrzeit);
        
        this.betrag = betrag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getBetrag() {
        return betrag;
    }
    
}
