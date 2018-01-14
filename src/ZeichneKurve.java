
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

public class ZeichneKurve extends javax.swing.JPanel {

    private static int MAX_SCORE;
    private static final int BORDER_GAP = 2;
    private static final Color GRAPH_COLOR = Color.green;
    private static final Color GRAPH_POINT_COLOR = Color.YELLOW;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 12;
    private List<Double> werte;

    public ZeichneKurve() {
        this.werte = new ArrayList<>();
        MAX_SCORE = (int) Manager.getPreis() * 25;
    }

    public ZeichneKurve(List<Double> werte) {
        this();
        this.werte = werte;
    }

    public void setWerte(List<Double> werte) {
        this.werte = werte;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (werte.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < werte.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((MAX_SCORE - werte.get(i)) * yScale + BORDER_GAP);
            graphPoints.add(new Point(x1, y1));
        }

        // create x and y axes 
        graphics2D.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        graphics2D.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        // create hatches for x axis
        for (int i = 0; i < werte.size() - 1; i++) {
            int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (werte.size() - 1) + BORDER_GAP;
            int x1 = x0;
            int y0 = getHeight() - BORDER_GAP;
            int y1 = y0 - GRAPH_POINT_WIDTH;
            graphics2D.drawLine(x0, y0, x1, y1);
        }

        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setColor(GRAPH_COLOR);
        graphics2D.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            graphics2D.drawLine(x1, y1, x2, y2);
        }

        graphics2D.setStroke(oldStroke);
        graphics2D.setColor(GRAPH_POINT_COLOR);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
            int ovalW = GRAPH_POINT_WIDTH;
            int ovalH = GRAPH_POINT_WIDTH;
            graphics2D.fillOval(x, y, ovalW, ovalH);
        }
    }
}
