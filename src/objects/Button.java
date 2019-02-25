package objects;
import engine.MouseHandler;
import engine.MainManager;
import methods.Draw;
import java.awt.Rectangle;
import java.awt.Font;
import resources.Fonts;
import java.awt.Graphics2D;
import java.awt.Color;
public class Button extends base.Object{
  //===================================================================VARIABLES
  public static final String CLASS = "Button";
  private int x;
  private int y;
  private int width;
  private int height;
  private Color color;
  private int oWidth;
  private Color oColor;
  private String txt;
  private Font font;
  private Color fColor;
  //====================================================================EXTERNAL
  //returns true if the button is clicked
  public boolean isClicked(int mb){
    return MouseHandler.isClicked(mb) && MouseHandler.getX() > this.x  && MouseHandler.getY() > this.y
           && MouseHandler.getX() < this.x + this.width && MouseHandler.getY() <  this.y + this.height;
  }
  //draw event
  @Override
  public void draw(Graphics2D g2){
    Draw.rect(g2, this.x, this.y, this.width, this.height, this.oWidth, this.color, this.oColor);
    Draw.ccString(g2, this.txt, this.x + this.width/2, this.y + this.height/2, this.fColor, this.font );
  }
  //======================================================================CREATE
  //button of the dimension x,y,width,height, inside color "color" and outside color oColor, it displays the string "txt" with the font "font"
  public Button( int x, int y, int width, int height, Color color, int oWidth, Color oColor, String txt , Font font, Color fColor){
    this.x = MainManager.scaleH(x);
    this.y = MainManager.scaleV(y);
    this.width = MainManager.scaleH(width);
    this.height = MainManager.scaleV(height);
    this.color = color;
    if(MainManager.scaleV(oWidth)<1){
      this.oWidth = MainManager.scaleV(oWidth);
    }else{
      this.oWidth = 1;
    }
    this.oColor = oColor;
    this.txt = txt;
    this.font = Fonts.scaleF(font);
    this.fColor = fColor;
    this.setClassNameVar(CLASS);
  }
}
