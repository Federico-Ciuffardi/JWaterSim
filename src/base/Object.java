package base;
import java.awt.Graphics2D;
public class Object{
  //===================================================================VARIABLES
  public String className;
  //==================================================================IMPLEMENTS
  //tick of the obj
  public void draw(Graphics2D g2){

  }
  //tick of the obj
  public void tick(){

  }
  //====================================================================EXTERNAL
  public String getType(){
    return this.className;
  }
  public void setClassNameVar(String s){
    this.className = s;
  }
  //======================================================================CREATE
  public Object(){
  }
}
