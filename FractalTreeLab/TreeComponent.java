import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JPanel;


public class TreeComponent extends JPanel
{
    private static final int PANEL_WIDTH = 700;
    private static final int PANEL_HEIGHT = 700;
    private double angle = 30;
    private double length;
    private Line2D.Double line;
    
    
    public TreeComponent( double len )
    {   
        this.length = len;
        this.setBackground( Color.BLACK );
        this.setPreferredSize( new Dimension( PANEL_WIDTH, PANEL_HEIGHT ) );
    }
    
    public void drawFractal( Graphics2D g, double len, double x, double y)
    {        
        double cos, sin, x2, y2, x3, y3, x4, y4;
        
        if( len == length )
        {
            x2 = x;
            y2 = y - len;
            line = new Line2D.Double( x, y, x2, y2 );
            g.draw( line );
            len -= 5;
        }
        else
        {
            cos = Math.cos( this.angle ) * ( len / 2 );
            sin = Math.sin( this.angle ) * ( len / 2 );

            y3 = y - cos;
            x3 = x - sin;
            y4 = y + cos;
            x4 = x + sin;
            
            drawFractal( g, len-5, x3, y3 );
            drawFractal( g, len-5, x4, y4 );
        }
    }
    
    public void paintComponent( Graphics2D g )
    {
        super.paintComponent( g );
        Graphics2D g2 = ( Graphics2D ) g;
        g2.setColor( Color.BLUE );
        drawFractal( g2, this.length, 350, 700 );
    }
}
