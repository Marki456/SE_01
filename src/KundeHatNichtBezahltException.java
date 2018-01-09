
public class KundeHatNichtBezahltException extends Exception {

    public KundeHatNichtBezahltException() {
        this("Der Kunde hat nicht bezahlt!");
    }
    
    public KundeHatNichtBezahltException(String message) {
        super(message);
    }
    
}
