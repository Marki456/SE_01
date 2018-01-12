
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassiererTest {
    
    public KassiererTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNeuerKunde() {
        Kunde kunde = new Kunde();
        double preis = 5;
        assertEquals(preis, Kassierer.kassieren(kunde, preis), 0.01);
    }
    
    @Test
    public void testEineStunde() {
        Kunde kunde = new Kunde(Zeit.getZeit() + 1);
        double preis = 5;
        assertEquals(preis * 2, Kassierer.kassieren(kunde, preis), 0.01);
    }
    
    @Test
    public void testEinJahr() {
        Kunde kunde = new Kunde(Zeit.getZeit() + 365*24);
        double preis = 5;
        assertEquals(preis * ((365 * 24) + 1), Kassierer.kassieren(kunde, preis), 0.01);
    }
}
