package methods;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
public class Draw{
  //====================================================================EXTERNAL
  //draws rect with outline
  public static void rect(Graphics2D g2, int x, int y, int width, int height, int oWidth, Color c, Color oC){
    g2.setColor( oC );
    g2.fillRect( x , y, width, height );
    g2.setColor( c );
    g2.fillRect( x + oWidth, y + oWidth, width - 2*oWidth, height - 2*oWidth );
  }
  //draws string center
  public static void ccString( Graphics2D g2, String s , int x, int y ,Color c , Font f ){
    g2.setColor( c );
    g2.setFont( f );
    FontMetrics fm = g2.getFontMetrics();
    Rectangle2D bnds = fm.getStringBounds(s, g2);
    g2.drawString( s , x - (int)bnds.getWidth()/2 , y + (int)bnds.getHeight()/4);

  }
  //draws string left
  public static void luString( Graphics2D g2, String s, int x, int y,Color c, Font f ){
    g2.setColor( c );
    g2.setFont( f );
    FontMetrics fm = g2.getFontMetrics();
    Rectangle2D bnds = fm.getStringBounds(s, g2);
    g2.drawString( s , x, y + (int)bnds.getHeight());
  }
  //draws a background on g2 color will be the color of the background
  public static void background( Graphics2D g2, Color color ){
    g2.setColor( color );
    g2.fillRect( 0 , 0, engine.MainManager.getWidth(), engine.MainManager.getHeight() );
  }
  //draws the FPS and TPS (SCALED!)
  public static void FPS( Graphics2D g2, Color color , Font font){
    /*
    g2.setColor( color );
    g2.setFont( resources.Fonts.scaleF(font) );
    g2.drawString( "FPS: " +  engine.MainLoop.getFPS() , engine.MainManager.scaleH(1500), engine.MainManager.scaleV(20) );
    g2.drawString( "TPS: " +  engine.MainLoop.getTPS() , engine.MainManager.scaleH(1500), engine.MainManager.scaleV(40) );
    */
  }
}
