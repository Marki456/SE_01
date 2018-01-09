
import java.util.List;

public abstract class TemplateEinnahmen {
    public double summe(List<Einnahme> list) {
        return list.stream()
                .peek(einnahme -> System.out.println(System.nanoTime() - einnahme.getTimestamp() < zeitraum()))
                .filter(einnahme -> System.nanoTime() - einnahme.getTimestamp() < zeitraum())
                .mapToDouble(einnahme -> einnahme.getBetrag())
                .sum();
    }

    public abstract long zeitraum();
}
