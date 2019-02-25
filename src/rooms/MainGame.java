package rooms;
import engine.MainManager;
import base.Object;
import methods.Draw;
import resources.Colors;
import resources.Fonts;
import java.awt.Graphics2D;
public class MainGame extends base.Room {
  //===================================================================CONSTANTS
  public static final String ROOM_NAME = "MainGame";
  //====================================================================EXTERNAL
  //draw event
  @Override
  public void draw(Graphics2D g2){
    Draw.background( g2 ,Colors.BACKGROUND );
    //objects
    this.processObjectsDraws(g2);
    //UI
    Draw.FPS( g2, Colors.UI, Fonts.FPS);
  }
  //tick event
  @Override
  public void tick(){
    this.processObjectsTicks();
  }
  //======================================================================CREATE
  //sets the rooms objects
  public MainGame(){
    this.setRoomName(ROOM_NAME);
    this.addObject(new objects.World());    
  }
}
