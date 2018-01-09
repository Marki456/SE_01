
public class MonatsEinnahmen extends TemplateEinnahmen{

    @Override
    public long zeitraum() {
        return 30L*86400000000000L;
    }
    
}
