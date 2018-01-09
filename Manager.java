
import java.util.ArrayList;
import java.util.List;

public class Manager {

    // Anfang Attribute
    private int[] Oeffnungszeit = {0, 23};
    private int Stellplaetze;
    private int Kassenstand;
    private List<Einnahme>[] einnahmen;
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
        
        kunden = new ArrayList<>();
        
        summen = new TemplateEinnahmen[4];
        summen[0] = new TagesEinnahmen();
        summen[1] = new WochenEinnahmen();
        summen[2] = new MonatsEinnahmen();
        summen[3] = new JahresEinnahmen();
    }

    public double getEinnahmen(int einnahmeZeitraum) {
        //einnahmeZeitraum: 0 für Tag, 1 für Woche, 2 für Monat, 3 für Jahr
        //                  alles andere wird als 0 gedeutet
        return summen[einnahmeZeitraum].summe(einnahmen[einnahmeZeitraum]);
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
