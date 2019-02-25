package rooms;
import engine.MainManager;
import base.Object;
import methods.Draw;
import objects.Button;
import resources.Colors;
import resources.Fonts;
import java.awt.Graphics2D;
public class MainMenu extends base.Room {
  //===================================================================CONSTANTS
  public static final String ROOM_NAME = "MainMenu";
  //====================================================================EXTERNAL
  //draw event
  @Override
  public void draw(Graphics2D g2){
    Draw.background( g2 , Colors.BACKGROUND );
    Draw.FPS( g2, Colors.UI, Fonts.FPS );
    this.processObjectsDraws(g2);
  }
  //tick event
  @Override
  public void tick(){
    this.processObjectsTicks();
  }
  //======================================================================CREATE
  //sets the rooms objects
  public MainMenu(){
    this.setRoomName(ROOM_NAME);
    //NEW GAME BUTTON
    this.addObject(new Button(25 ,125 , 250, 50, Colors.BTN, 2, Colors.BTN_OUT, "START SIMULATION",Fonts.BTN_SMALL,  Colors.BTN_TEXT){
      @Override
      public void tick(){
        if(this.isClicked(1)){
          engine.MainManager.gs.restart();
          engine.MainManager.setRoom(new MainGame());
        }
      }
    });
  }
}
