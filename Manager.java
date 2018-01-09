
import java.util.List;

public class Manager {

    // Anfang Attribute
    int[] Oeffnungszeit = {0, 23};
    int Stellplaetze;
    int Kassenstand;
    private List<Einnahme>[] Einnahmen_1;
    private TemplateEinnahmen[] summen;
    Kunde[] Kunden;

    Kassierer k = new Kassierer();
    Einweiser e;
    Schrankwaerter s = new Schrankwaerter();

    // Ende Attribute
    // Anfang Methoden
    Manager(int Kassenstand, int[] StellplatzeProEtage) {
        e = Einweiser.einweiseranlegen(StellplatzeProEtage);
        this.Kassenstand = Kassenstand;
        Stellplaetze = 0;
        for (int i = 0; i < StellplatzeProEtage.length; i++) {
            Stellplaetze = StellplatzeProEtage[i] + Stellplaetze;
        }
        
        summen = new TemplateEinnahmen[4];
        summen[0] = new TagesEinnahmen();
        summen[1] = new WochenEinnahmen();
        summen[2] = new MonatsEinnahmen();
        summen[4] = new JahresEinnahmen();
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

    public double getEinnahmen(int einnahmeZeitraum) {
        //einnahmeZeitraum: 0 für Tag, 1 für Woche, 2 für Monat, 3 für Jahr
        //                  alles andere wird als 0 gedeutet
        return summen[einnahmeZeitraum].summe(Einnahmen_1[einnahmeZeitraum]);
    }

    public void Einnahmen(String Zeitraumbeginn, String Zeitraumende) {

    }

    public Kunde[] getKunden() {
        return Kunden;
    }

    public void setKunden(Kunde[] Kunden) {
        this.Kunden = Kunden;
    }

    public boolean getSchrankwaerter() {
        return s.getSchranke();
    }

    // Ende Methoden
}
