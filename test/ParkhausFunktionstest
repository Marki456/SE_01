import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkhausFunktionstest {
	int Plaetze[] = {20,20,10};
	Manager m = new Manager(23,Plaetze);
	
	Kunde c = new Kunde();
	Kunde d = new Kunde();
	Kunde e = new Kunde();

	Einweiser einweiser;
    
    @Before
    public void setUp() throws ParkhausIstVollException {
    	
    	m = new Manager(23,Plaetze);
    	einweiser = Einweiser.einweiseranlegen(Plaetze);
    
    	m.addKunde(c);
   		m.addKunde(d);
   		m.addKunde(e);
   	
   		
    }
    @After
    public void tearDown() throws KundeHatNichtBezahltException {
    	m.bezahlen(c);
    	m.bezahlen(d);
    	m.bezahlen(e);
    	m.verlassen(c);
    	m.verlassen(d);
    	m.verlassen(e);
    }

    @Test
    public void testStellpaltz() {
      assertTrue(c.getStellplatz().equals("2.0"));
    }
    @Test
    public void testStellplatzbelegt(){
    	assertTrue(einweiser.Stellplatzbelegt("2.19"));
    }
    @Test
    public void testStellplatzbelegt_2() throws KundeHatNichtBezahltException{
    	m.bezahlen(c);
    	m.bezahlen(d);
    	m.bezahlen(e);
    	m.verlassen(c);
    	m.verlassen(d);
    	m.verlassen(e);
    	assertFalse(einweiser.Stellplatzbelegt("2.0"));
    }
    @Test
    public void testStellplatzbelegt_3(){
    	assertTrue(m.getStellplaetze()==47);
    }
    
}

