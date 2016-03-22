import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
// import java.awt.event.MouseMotionListener;
// import java.awt.event.MouseEvent;

public class TreeComponent extends JPanel
{
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 800;
    //     private double angle;
    private double angle2 = Math.toRadians( 35 );
    //     private int when = 0;
    private Line2D.Double line;
    private Line2D.Double line2;
    //     private MouseMotionListener motion_listener;

    public TreeComponent()
    {   
        this.setBackground( Color.BLACK );
        this.setPreferredSize( new Dimension( PANEL_WIDTH, PANEL_HEIGHT ) );
        // 
        //         this.motion_listener = new MouseMotListener();
        //         this.addMouseMotionListener( motion_listener );
    }

    public void drawFractal( double len, double x, double y, double ang, Graphics2D g2)
    {        
        double x2, y2, x3, y3;

        if( len == 0 )
        {
            return;
        }
        else
        {
            x2 = ( int )( x - len * Math.sin( ang + this.angle2 ) );
            y2 = ( int )( y - len * Math.cos( ang + this.angle2 ) );
            x3 = ( int )( x - len * Math.sin( ang - this.angle2 ) );
            y3 = ( int )( y - len * Math.cos( ang - this.angle2 ) );

            line = new Line2D.Double( x, y, x2, y2 );
            g2.draw( line );

            line2 = new Line2D.Double( x, y, x3, y3 );
            g2.draw( line2 );

            drawFractal( len - 10, x2, y2, ang + this.angle2, g2 );

            drawFractal( len - 10, x3, y3, ang - this.angle2, g2 );

        }
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2 = ( Graphics2D ) g;

        g2.setColor( Color.GREEN );

        drawFractal( 100, 400, 600, 0, g2 );
    }

    //     class MouseMotListener implements MouseMotionListener
    //     {
    //         private Point2D.Double mouse_loc;
    //         
    //         
    //         public void mouseDragged( MouseEvent event )
    //         {
    //            
    //         }
    //         
    //         public void mouseMoved( MouseEvent event )
    //         {
    //             when += 1;
    //             if( when%20 == 0 )
    //             {
    //                 angle = event.getY() + angle2;
    //             }
    //             repaint();
    //         }
    //     }
}
