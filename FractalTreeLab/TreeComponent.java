import java.awt.*;
import javax.swing.JPanel;


public class TreeComponent extends JPanel
{
    private static final int PANEL_WIDTH = 700;
    private static final int PANEL_HEIGHT = 700;
    private final int botX = 350, botY = 700;
    private final int topX = 350, topY = 600;
    private final double angle = 30;
    private int current;
    private double deltaX, deltaY;
    private int lefX, lefY;
    private int rigX, rigY;
    private final double half = this.deltaY / 2;
    private final double adj = Math.cos( this.angle ) * half;
    
    
    public TreeComponent( int cur )
    {
        this.current = cur;
        
        this.setBackground( Color.BLACK );
        this.setPreferredSize( new Dimension( PANEL_WIDTH, PANEL_HEIGHT ) );
        
        this.lefY = Math.floor( 700 - (this.deltaY + this.adj) );
    }
    
    public void drawFractal( Graphics g2 )
    {
        
        
        if( current == 10 )
        {
            g2.drawLine( this.botX, this.botY, this.topX, this.topY );
            this.current -= 1;
        }
        else
        {
            this.deltaX = this.topX - this.botX;
            this.deltaY = this.topY - this.botY;
            
            drawFractal( g2 );
        }
    }
    
    public void paintComponent( Graphics g2 )
    {
        super.paintComponent( g2 );
        g2.setColor( Color.BLUE );
        
        drawFractal( g2 );
    }
}
