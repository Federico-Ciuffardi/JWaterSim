import engine.MainLoop;
//project name display and main loop initialization
public class Main{
  public static void main( String[] args ){
    System.out.println( "project" );
    new Thread( new MainLoop() ).start();
  }
}
