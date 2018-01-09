
public class JahresEinnahmen extends TemplateEinnahmen{

    @Override
    public long zeitraum() {
        return 365L*86400000000000L;
    }
    
}
