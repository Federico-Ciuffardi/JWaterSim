package engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{
  //===================================================================VARIABLES
  private static final int MAX_KEY = 223;
	public static boolean[] activeKeys = new boolean[MAX_KEY];
  //====================================================================EXTERNAL
  //returs true if the key k is active
  //PREC: 0 =< k < MAX_KEY
  public static boolean isActive( int k ){
    return activeKeys[k];
  }
  //====================================================================INTERNAL
  @Override
  public void keyPressed(KeyEvent e){//consumir true para un Pressed o hacer como hice en el click
    if (e.getKeyCode() < MAX_KEY){
      activeKeys[e.getKeyCode()] = true;
    }else{
      System.out.println("key out of range:" + e.getKeyCode());
    }
  }
  @Override
  public void keyReleased(KeyEvent e){
    if (e.getKeyCode() < MAX_KEY){
      activeKeys[e.getKeyCode()] = false;
    }
  }
  @Override
  public void keyTyped(KeyEvent e){}
}
