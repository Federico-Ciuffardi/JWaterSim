package objects;
import misc.Pixel;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.ListIterator;
public class World extends base.Object{
  //===================================================================VARIABLES
  public static final String CLASS = "World";
  private final int PXL_LENGTH = 4;
  private final int HEIGHT = 575/PXL_LENGTH;
  private final int WIDTH = 600/PXL_LENGTH;

  private Pixel[][] pxlArr;
  private LinkedList<Pixel> activePixels;
  private LinkedList<Pixel> activePixelsAux;
  //====================================================================EXTERNAL
  //returns true if the button is clicked
  public boolean isClicked(int mb){
    return false;
  }
  //draw event
  @Override
  public void draw(Graphics2D g2){
    ListIterator<Pixel> iter = this.activePixels.listIterator(0);
    while(iter.hasNext()){
      iter.next().draw(g2, PXL_LENGTH);
    }
  }
  //draw event
  @Override
  public void tick(){
    if(engine.KeyHandler.isActive( 'r' ) || engine.KeyHandler.isActive( 'R' ) ){
      engine.MainManager.gs.restart();
      engine.MainManager.setRoom(new rooms.MainGame());
    }
    ListIterator<Pixel> iter = this.activePixels.listIterator(0);
    while(iter.hasNext()){
      this.gravity(iter.next(), iter);
    }
    for(int i = 0; i < WIDTH; i++){
      for(int j = 0; j < HEIGHT; j++){
        if(this.pxlArr[i][j].getState()!= -1)
        this.activePixelsAux.addFirst(this.pxlArr[i][j]);
      }
    }
    this.activePixels = this.activePixelsAux;
    this.activePixelsAux = new LinkedList<Pixel>();

  }
  public void addPixel(int state, int i, int j){
    this.pxlArr[i][j] = new misc.Pixel(state, i, j);
    if( state != -1){
      this.activePixels.addFirst(this.pxlArr[i][j]);
    }
  }
  public void gravity(Pixel pxl,ListIterator<Pixel> iter ){
    if(!pxl.isRidgid()){
       if(  pxl.getJ() < HEIGHT-1 && this.pxlArr[pxl.getI()][pxl.getJ()+1].getState() == -1 ){
        this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],0,1,iter);
      }else{
        if( pxl.getLastDirI() >= 0){
          if(  pxl.getI() < WIDTH-1 &&  pxl.getJ() < HEIGHT-1 && this.pxlArr[pxl.getI()+1][pxl.getJ()+1].getState() == -1 && this.pxlArr[pxl.getI()+1][pxl.getJ()].getState() == -1  ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],1,1,iter);
          }else if(  pxl.getI() > 0 && pxl.getJ() < HEIGHT-1 && this.pxlArr[pxl.getI()-1][pxl.getJ()+1].getState() == -1 && this.pxlArr[pxl.getI()-1][pxl.getJ()].getState() == -1 ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],-1,1,iter);
          }
          if(  pxl.getI() < WIDTH-1 && this.pxlArr[pxl.getI()+1][pxl.getJ()].getState() == -1 ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],1,0,iter);
          }else if(  pxl.getI() > 0 && this.pxlArr[pxl.getI()-1][pxl.getJ()].getState() == -1 ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],-1,0,iter);
          }
        }else{
          if(  pxl.getI() > 0 && pxl.getJ() < HEIGHT-1 && this.pxlArr[pxl.getI()-1][pxl.getJ()+1].getState() == -1 && this.pxlArr[pxl.getI()-1][pxl.getJ()].getState() == -1){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],-1,1,iter);
          }else if(  pxl.getI() < WIDTH-1 && pxl.getJ() < HEIGHT-1 && this.pxlArr[pxl.getI()+1][pxl.getJ()+1].getState() == -1 && this.pxlArr[pxl.getI()+1][pxl.getJ()].getState() == -1){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],1,1,iter);
          }
          if(  pxl.getI() > 0 && this.pxlArr[pxl.getI()-1][pxl.getJ()].getState() == -1 ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],-1,0,iter);
          }else if(  pxl.getI() < WIDTH-1 && this.pxlArr[pxl.getI()+1][pxl.getJ()].getState() == -1 ){
            this.movePixel(pxlArr[pxl.getI()][pxl.getJ()],1,0,iter);
          }
        }
      }
    }
  }
  public void movePixel(Pixel pxl,int iI, int iJ, ListIterator<Pixel> iter){
    int i = pxl.getI();
    int j = pxl.getJ();
    Pixel aux = this.pxlArr[i + iI][j +iJ];
    this.pxlArr[i + iI][j + iJ] = pxl;
    this.pxlArr[i][j] = aux;
    aux.movePixel(-iI,-iJ);
    pxl.movePixel(iI,iJ);
  }
  //======================================================================CREATE
  public World(){
    this.setClassNameVar(CLASS);
    this.pxlArr = new misc.Pixel[WIDTH][HEIGHT];//dps listas current y next
    this.activePixels = new java.util.LinkedList<Pixel>();
    this.activePixelsAux = new java.util.LinkedList<Pixel>();
    for(int i = 0; i < WIDTH; i++){
      for(int j = 0; j < HEIGHT; j++){
	int state;
	if(j<HEIGHT/2){
        state = methods.Rand.nextInt(-1,1);
	}else{
		state = -1;
	}
        this.addPixel(state,i,j );
      }
    }
  }
}
