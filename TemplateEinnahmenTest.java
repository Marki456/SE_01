
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemplateEinnahmenTest {
    List<Einnahme> list;
    
    public TemplateEinnahmenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(new Einnahme(System.nanoTime(), 100));
        list.add(new Einnahme(System.nanoTime() - 86400000000000L + 3600000000000L, 100));
        list.add(new Einnahme(System.nanoTime() - 6L*86400000000000L, 100));
        list.add(new Einnahme(System.nanoTime() - 29L*86400000000000L, 100));
        list.add(new Einnahme(System.nanoTime() - 364L*86400000000000L, 100));
        list.add(new Einnahme(System.nanoTime() - 400L*86400000000000L, 100));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTag() {
        TemplateEinnahmen instance = new TagesEinnahmen();
        double expResult = 200;
        double result = instance.summe(list);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testWoche() {
        TemplateEinnahmen instance = new WochenEinnahmen();
        double expResult = 300;
        double result = instance.summe(list);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testMonat() {
        TemplateEinnahmen instance = new MonatsEinnahmen();
        double expResult = 400;
        double result = instance.summe(list);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testJahr() {
        TemplateEinnahmen instance = new JahresEinnahmen();
        double expResult = 500;
        double result = instance.summe(list);
        assertEquals(expResult, result, 0.001);
    }
    
}
