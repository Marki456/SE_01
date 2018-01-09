
import java.util.ArrayList;
import java.util.List;

public class Manager {

    // Statische Konstanten
    public static final int TAG = 0;
    public static final int WOCHE = 1;
    public static final int MONAT = 2;
    public static final int JAHR = 3;
    
    // Anfang Attribute
    private final double PREIS = 5;
    private int[] Oeffnungszeit = {0, 23};
    private int Stellplaetze;
    private int Kassenstand;
    private List<Einnahme> einnahmen;
    private TemplateEinnahmen[] summen;
    private List<Kunde> kunden;
    private Kassierer kassierer = new Kassierer();
    private Einweiser einweiser;
    private Schrankwaerter schrankwaerter = new Schrankwaerter();
    // Ende Attribute
    
    // Anfang Methoden
    public Manager(int Kassenstand, int[] StellplatzeProEtage) {
        einweiser = Einweiser.einweiseranlegen(StellplatzeProEtage);
        this.Kassenstand = Kassenstand;
        Stellplaetze = 0;
        for (int i = 0; i < StellplatzeProEtage.length; i++) {
            Stellplaetze = StellplatzeProEtage[i] + Stellplaetze;
        }
        
        einnahmen = new ArrayList<>();
        kunden = new ArrayList<>();
        
        summen = new TemplateEinnahmen[4];
        summen[0] = new TagesEinnahmen();
        summen[1] = new WochenEinnahmen();
        summen[2] = new MonatsEinnahmen();
        summen[3] = new JahresEinnahmen();
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

    public void bezahlen(Kunde kunde) {
        einnahmen.add(new Einnahme(kassierer.kassieren(kunde, PREIS)));
    }

    public void addKunde(Kunde kunde) {
        kunden.add(kunde);
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
