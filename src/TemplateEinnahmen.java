
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TemplateEinnahmen {

    SimpleDateFormat sdf;

    public TemplateEinnahmen() {
        sdf = new SimpleDateFormat("HH");
    }

    public double summe(List<Einnahme> list) {
        String uhrzeitString = sdf.format(new Date());
        int uhrzeit = Integer.parseInt(uhrzeitString);
        return list.stream()
                .filter(einnahme -> uhrzeit - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .sum();
    }

    public List<Double> werte(List<Einnahme> list) {
        String uhrzeitString = sdf.format(new Date());
        int uhrzeit = Integer.parseInt(uhrzeitString);
        List<Double> werte = new ArrayList<>();
        list.stream()
                .filter(einnahme -> uhrzeit - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .forEach(d -> werte.add(d));
        return werte;
    }

    public abstract int zeitraum();
}
