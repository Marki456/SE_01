import java.text.SimpleDateFormat;
import java.util.Date;
public class Kassierer {
    public int kassieren(Kunde k, int Preis){
       
        
        	SimpleDateFormat sdf = new SimpleDateFormat("HH");
		String uhrzeit = sdf.format(new Date());
		int Jetzt = Integer.parseInt(uhrzeit);
		int Rechnung = (k.getAnkunftszeit() - Jetzt)*Preis;
		k.setBezhalt(true);
		return Rechnung;
    }
}
