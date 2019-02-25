package engine;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
public class MouseHandler implements java.awt.event.MouseListener{
	//===================================================================VARIABLES
	public static final int MAX_KEY = 4;
	public static boolean[] mouseActive = new boolean[MAX_KEY];
	public static boolean[] mouseClicked = new boolean[MAX_KEY];
	public static int mY;
	public static int mX;
	private static int mYOffset;
	private static int mXOffset;
	//====================================================================EXTERNAL
	//returns mouse x location
	public static int getX(){
		return mX;
	}
	//returns mouse y location
	public static int getY(){
		return mY;
	}
	//returns if mouse button mb is active
	//PREC: 0 =< mb < MAX_KEY
	public static boolean isActive(int mb){
		return mouseActive[mb];
	}
	//returns true if mouse button mb is clicked
	public static boolean isClicked(int mb){
		return mouseClicked[mb];
	}
	//returns if mouse button mb is active
	public static void updateMousePosition(){
		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		mY = mouseLocation.y - MainManager.getDisplay().getY() - mYOffset;
		mX = mouseLocation.x - MainManager.getDisplay().getX() - mXOffset;
	}
	//reset the click info to not clicked (must be aplied at the end section of the tick loop for proper click work)
	public  static void restoreClickInfo(){
		for(int i = 0; i < MouseHandler.MAX_KEY; i++){
			MouseHandler.mouseClicked[i] = false;
		}
	}
	//======================================================================CREATE
	public MouseHandler(){
		if (MainManager.isWindows()){
			mXOffset = 3;
			mYOffset = 26;
		}
		else{
			mXOffset = 0;
			mYOffset = 30;
		}
	}
	//====================================================================INTERNAL
	@Override
	public void mousePressed(MouseEvent e){
		System.out.println("mouseLocation-("+mX+","+mY+")");
		if (e.getButton()< 4)
			mouseActive[e.getButton()] = true;
	}
	@Override
	public void mouseReleased(MouseEvent e){
		if (e.getButton()< 4)
			mouseActive[e.getButton()] = false;
			mouseClicked[e.getButton()] = true;
	}
	@Override
	public void mouseEntered(MouseEvent e){
	}
	@Override
	public void mouseExited(MouseEvent e){
	}
	@Override
	public void mouseClicked(MouseEvent e){
	}
}
