package graphics;
import engine.MouseHandler;
import engine.KeyHandler;
import engine.MainManager;
import javax.swing.JPanel;

public class Display extends javax.swing.JFrame{
  //===================================================================VARIABLES
  private JPanel currentPanel;
  //====================================================================EXTERNAL
  //Sets the panel jPanel as the only display panel
  public void setPanel( JPanel panel ){
    this.getContentPane().removeAll();
    this.add( panel );
    panel.setBounds( 0, 0, MainManager.getWidth(), MainManager.getHeight() );
    currentPanel = panel;
  }
  //======================================================================CREATE
  //creates a window with frameWidth and frameHeight as dimensions and the boolean is for proper working on both Windows and linux(setSize problems)
  public Display( int frameWidth, int frameHeight, boolean IS_WINDOWS ){
    this.setDefaultCloseOperation( EXIT_ON_CLOSE);
    this.setResizable( false);
    this.setLayout(null);
    this.addMouseListener(new MouseHandler());
    this.addKeyListener(new KeyHandler());
    if( IS_WINDOWS){
      this.setSize( frameWidth + 6, frameHeight + 29 );
    }else{
      this.setSize( frameWidth, frameHeight );
    }
    this.setVisible( true );
  }

}
