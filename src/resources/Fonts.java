package resources;
import java.awt.Font;
import engine.MainManager;
public class Fonts{
  //=======================================================================FONTS
  public static final Font BTN_SMALL = new Font( "Courier New", 1, 20);
  public static final Font BTN_MED = new Font( "Courier New", 1, 30);
  public static final Font BTN_BIG= new Font( "Courier New", 1, 40);
  public static final Font TITLE = new Font( "Courier New", 1, 60);
  public static final Font UI = new Font( "Courier New", 1, 20);
  public static final Font FPS = new Font( "Arial" ,0 , 20 );

  public static Font scaleF(Font f){
    return f.deriveFont(f.getStyle(), MainManager.scaleV(f.getSize()));
  }
}
