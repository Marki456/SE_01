
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zeit {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH");
    private static int offset = 0;

    private Zeit(){}
    
    public static int getZeit() {
        String uhrzeitString = sdf.format(new Date());
        return Integer.parseInt(uhrzeitString) + offset;
    }
    
    public static void erhöheOffset(int offset){
        Zeit.offset += offset;
    }
}
