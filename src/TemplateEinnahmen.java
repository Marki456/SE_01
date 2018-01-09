import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class TemplateEinnahmen {
    public double summe(List<Einnahme> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
	String uhrzeitString = sdf.format(new Date());
        int uhrzeit = Integer.parseInt(uhrzeitString);
        return list.stream()
                .filter(einnahme -> uhrzeit - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .sum();
    }

    public abstract int zeitraum();
}
