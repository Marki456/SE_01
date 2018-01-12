
public class Schrankenwaerter {
    
    public void einfahren(Manager manager) throws ParkhausIstVollException {
        if (manager.getStellplaetze() == 0)
            throw new ParkhausIstVollException();
    }

    public void ausfahren(Kunde k) throws KundeHatNichtBezahltException {
        if (k.hatBezahlt() || k.hatNotfall())
            k.verlassen();
        else
            throw new KundeHatNichtBezahltException();
    }

}
