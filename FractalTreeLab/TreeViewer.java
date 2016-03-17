import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TreeViewer extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private Graphics2D g2;
    
    
    public static void main( String[] args )
    {
        TreeViewer forest = new TreeViewer();
    }
    
    public TreeViewer()
    {
        this.setTitle( "Fractal Forest" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( WIDTH, HEIGHT );
        this.setVisible( true );
        
        TreeComponent tree = new TreeComponent( 20 );
        
        this.add( tree );
    }
}
