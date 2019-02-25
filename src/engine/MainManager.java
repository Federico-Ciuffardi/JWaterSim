package engine;
import graphics.Display;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import base.Room;
public class MainManager{
  //===================================================================VARIABLES
  private final static int DEFAULT_WIDTH = 300;
  private final static int DEFAULT_HEIGHT = 300;
  private static int actualWidth = 600;
  private static int actualHeight = 600;
  private static boolean isWindows;
  private static Display display;
  private static Room currentRoom;
  public static GameState gs = new GameState();
  //====================================================================EXTERNAL
  //saves gs
  public static void loadGame(){
    try {
      FileInputStream fileIn = new FileInputStream("./saveData/save.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      gs = (GameState) in.readObject();
      in.close();
      fileIn.close();
    }catch(IOException i) {
      i.printStackTrace();
    }catch(ClassNotFoundException c) {
      System.out.println("Save not found");
    }
  }
  //loads gs
  public static void saveGame(){
    try {
      FileOutputStream fileOut = new FileOutputStream("./saveData/save.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(gs);
      out.close();
      fileOut.close();
    }catch(IOException i) {
      i.printStackTrace();
    }
  }
  //returns scaled from default height and width to the width and height
  public static int scaleV(int l){
    return ((getHeight()*10000/DEFAULT_HEIGHT)*l)/10000;
  }
  public static int scaleH(int l){
    return ((getWidth()*10000/DEFAULT_WIDTH)*l)/10000;
  }
  //returns display width
  public static int getWidth(){
    if( isWindows ){
      return display.getWidth() - 6;
    }else{
      return display.getWidth();
    }
  }
  //returns display height
  public static int getHeight(){
    if( isWindows ){
      return display.getHeight() - 29;
    }else{
      return display.getHeight();
    }
  }
  //returns display
  public static Display getDisplay(){
    return display;
  }
  //returns true if is Windows
  public static boolean isWindows(){
    return isWindows;
  }
  //return the currentRoom
  public static Room getRoom(){
    return currentRoom;
  }
  //runs next tick
  public static void nextTick(){
    MouseHandler.updateMousePosition();
    currentRoom.tick();
    MouseHandler.restoreClickInfo();
  }
  //draws next frame
  public static void nextFrame(){
    currentRoom.repaint();
  }
  //set a new room as current
  public static void setRoom( Room room ){
    currentRoom = room;
    display.setPanel( currentRoom );
  }

  //======================================================================CREATE
  //initializes the MainManager
  public static void initialize(){
    isWindows = System.getProperty( "os.name" ).indexOf( "Windows" ) != -1;
    display = new Display( actualWidth ,actualHeight ,isWindows );
    setRoom( new rooms.MainMenu() );
  }
}
