
import java.util.ArrayList;
import java.util.List;

public class Manager {

    // Statische Konstanten
    public static final int TAG = 0;
    public static final int WOCHE = 1;
    public static final int MONAT = 2;
    public static final int JAHR = 3;
    
    // Anfang Attribute
    private static final double PREIS = 5;
    private int[] Oeffnungszeit = {0, 23};
    private int Stellplaetze;
    private int Kassenstand;
    private List<Einnahme> einnahmen;
    private TemplateEinnahmen[] summen;
    private List<Kunde> kunden;
    private Einweiser einweiser;
    private Schrankenwaerter schrankwaerter;
    // Ende Attribute
    
    // Anfang Methoden
    public Manager(int Kassenstand, int[] StellplatzeProEtage) {
        einweiser = Einweiser.getInstance(StellplatzeProEtage);
        this.Kassenstand = Kassenstand;
        Stellplaetze = 0;
        for (int i = 0; i < StellplatzeProEtage.length; i++) {
            Stellplaetze = StellplatzeProEtage[i] + Stellplaetze;
        }
        
        schrankwaerter = new Schrankenwaerter();
        einnahmen = new ArrayList<>();
        kunden = new ArrayList<>();
        
        summen = new TemplateEinnahmen[4];
        summen[TAG] = new TagesEinnahmen();
        summen[WOCHE] = new WochenEinnahmen();
        summen[MONAT] = new MonatsEinnahmen();
        summen[JAHR] = new JahresEinnahmen();
    }
    
    /**
     * 
     * @param einnahmeZeitraum Eine der folgenden Werte: Manager.TAG, Manager.WOCHE, Manager.MONAT, Manager.JAHR
     * @return Die Einnahmen in diesem Zeitraum
     */
    public double getEinnahmen(int einnahmeZeitraum) {
        if (!(einnahmeZeitraum <= JAHR && TAG <= einnahmeZeitraum))
            einnahmeZeitraum = JAHR;
        return summen[einnahmeZeitraum].summe(einnahmen);
    }

    /**
     * 
     * @param einnahmeZeitraum Eine der folgenden Werte: Manager.TAG, Manager.WOCHE, Manager.MONAT, Manager.JAHR
     * @return Die Einnahmen in diesem Zeitraum
     */
    public List<Double> getEinnahmenAsIntegerList(int einnahmeZeitraum) {
        if (!(einnahmeZeitraum <= JAHR && TAG <= einnahmeZeitraum))
            einnahmeZeitraum = JAHR;
        return summen[einnahmeZeitraum].werte(einnahmen);
    }
    
    public void bezahlen(Kunde kunde) {
        double einnahme = Kassierer.kassieren(kunde, PREIS);
        if (einnahme < 1)
            return;
        einnahmen.add(new Einnahme(einnahme));
    }

    public void verlassen(Kunde kunde) throws KundeHatNichtBezahltException {
        schrankwaerter.ausfahren(kunde);
        einweiser.Stellplatzchange(kunde.getStellplatz());
        ++Stellplaetze;
    }

    public void addKunde(Kunde k) throws ParkhausIstVollException {
        schrankwaerter.einfahren(this);
        k.setStellplatz(einweiser.getStellplatz());
        kunden.add(k);
        --Stellplaetze;
    }
    
    public static double getPreis() {
        return PREIS;
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public int[] getOeffungszeiten() {
        return Oeffnungszeit;
    }

    public int getStellplaetze() {
        return Stellplaetze;
    }

    public int getKassenstand() {
        return Kassenstand;
    }
    // Ende Methoden
}
