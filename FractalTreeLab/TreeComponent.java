import java.awt.*;
import javax.swing.JPanel;


public class TreeComponent extends JPanel
{
    private static final int PANEL_WIDTH = 700;
    private static final int PANEL_HEIGHT = 700;
    private final int botX = 350, botY = 700;
    private final int topX = 350, topY = 600;
    private final int lefX, lefY;
    private final int rigX, rigY;
    private final int angle;
    private int current;
    private int deltaX, deltaY;
    
    
    public TreeComponent( int cur, int a )
    {
        this.current = cur;
        this.angle = a;
        
        this.setBackground( Color.BLACK );
        this.setPreferredSize( new Dimension( PANEL_WIDTH, PANEL_HEIGHT ) );
        
        
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
