
import java.util.ArrayList;
import java.util.List;

public abstract class TemplateEinnahmen {

    public double summe(List<Einnahme> list) {
        return list.stream()
                .filter(einnahme -> Zeit.getZeit() - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .sum();
    }

    public List<Double> werte(List<Einnahme> list) {
        List<Double> werte = new ArrayList<>();
        list.stream()
                .filter(einnahme -> Zeit.getZeit() - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .forEach(d -> werte.add(d));
        return werte;
    }

    public abstract int zeitraum();
}
