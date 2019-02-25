package misc;
import java.awt.Graphics2D;
import java.awt.Color;
public class Pixel{
  private int state; //-1 = void; 0 = solid , 1 = liquid, 2 = gas
  private Color color;
  private int i;
  private int j;
  private int lastDirI;
  private int lastDirJ;
  private boolean rigid;
  public int getState(){
    return  state;
  }
  public int getI(){
    return i;
  }
  public int getJ(){
    return j;
  }

  public Color getColor(){
    return this.color;
  }
  public int getLastDirI(){
    return lastDirI;
  }
  public boolean isRidgid(){
    return rigid;
  }
  public void tick(){
  }
  public void movePixel(int iI, int iJ){
    this.i += iI;
    this.j += iJ;
    if(iI != 0){
      this.lastDirI = iI;
    }
    if(iJ != 0){
      this.lastDirJ = iJ;
    }
  }
  public void draw(Graphics2D g2 , int PXL_LENGTH){
    g2.setColor( this.getColor());
    g2.fillRect(i*PXL_LENGTH,j*PXL_LENGTH,PXL_LENGTH,PXL_LENGTH);


  }
  public Pixel(int state, int i, int j){
    this.state = state;
    this.i = i;
    this.j = j;
    if(state == -1){
      this.color = Color.magenta;
      this.rigid = true;
    }else if( state == 0 ){
      this.rigid = true;
      this.color = Color.gray;
    }else if( state == 1){
      this.rigid = false;
      this.color = Color.blue;
    }else if( state == 2 ){
      this.rigid = true;
      this.color = Color.cyan;
    }
  }
}
