package base;
import base.Object;
import engine.MainLoop;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.RenderingHints;
import java.awt.Font;
public class Room extends javax.swing.JPanel {
  //===================================================================CONSTANTS
    //FONTS
  //===================================================================VARIABLES
  public String roomName;
  private LinkedList<Object> objects;
  //==================================================================IMPLEMENTS
  //draw of the room
  public void draw( Graphics2D g2){}
  //tick of the room
  public void tick(){}
  //==============================================================UTILS FOR SONS
  public void addObject(Object o){
    this.objects.add(o);
  }
  //does the tick function for all the objects of the room
  public void processObjectsTicks(){
    ListIterator<Object> i = this.objects.listIterator(0);
    while(i.hasNext()){
      i.next().tick();
    }
  }
  //does the draw function for all the objects of the room
  public void processObjectsDraws(Graphics2D g2){
    ListIterator<Object> i = objects.listIterator(0);
    while(i.hasNext()){
      i.next().draw( g2 );
    }
  }
  //====================================================================EXTERNAL
  //return the id of the room
  public String getID(){
    return this.roomName;
  }
  public void setRoomName(String s){
    this.roomName = s;
  }
  //====================================================================INTERNAL
  //does the always repeating thing of the paintComponent
  public void paintComponent( Graphics g ){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    this.draw(g2);
    Toolkit.getDefaultToolkit().sync();
  }
  //======================================================================CREATE
  public Room(){
    this.objects = new java.util.LinkedList<Object>();
  }
}
