
public class Manager {

    // Anfang Attribute
    int[] Oeffnungszeit = {0, 23};
    int Stellplaetze;
    int Kassenstand;
    int[] Einnahmen_1;
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

    public int[] getEinnahmen() {
        return Einnahmen_1;
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
