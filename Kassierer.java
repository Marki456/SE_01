import java.text.SimpleDateFormat;
import java.util.Date;
public class Kassierer {
    private SimpleDateFormat sdf;
                
    public Kassierer(){
        	sdf = new SimpleDateFormat("HH");
    }
    
    public int kassieren(Kunde k, int Preis){
		String uhrzeit = sdf.format(new Date());
		int Jetzt = Integer.parseInt(uhrzeit);
		int Rechnung = (k.getAnkunftsZeit() - Jetzt)*Preis;
		k.setHatBezahlt();
		return Rechnung;
    }
}
