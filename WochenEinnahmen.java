
public class WochenEinnahmen extends TemplateEinnahmen{

    @Override
    public long zeitraum() {
        return 7L*86400000000000L;
    }
    
}
