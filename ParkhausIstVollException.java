
public class ParkhausIstVollException extends Exception {

    public ParkhausIstVollException() {
        this("Das Parkhaus ist voll!");
    }
    
    public ParkhausIstVollException(String message) {
        super(message);
    }
}
