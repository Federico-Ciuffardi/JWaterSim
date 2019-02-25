package engine;
public class MainLoop implements Runnable{
	//===================================================================VARIABLES
	private final long SEC_IN_NANOSEC = 1000000000;
	private final int TARGET_FPS = 45 + 1;
  private final int TARGET_TPS = 45 + 1;
	private final long TARGET_TIME_BETWEEN_FRAMES = SEC_IN_NANOSEC/TARGET_FPS;
	private final long TARGET_TIME_BETWEEN_TICKS = SEC_IN_NANOSEC/TARGET_TPS;
	private boolean isRunning = true;
	private long lastNanosecondPaint = System.nanoTime();
  private long lastNanosecondTick = System.nanoTime();
	private long lastSecond = System.nanoTime();
	private long actualNanosecond = System.nanoTime();
	private int preFPS = 0;
  private int preTPS = 0;
	private static int FPS = 0;
	private static int TPS = 0;
	//====================================================================EXTERNAL
	//return the FPS
	public static int getFPS(){
		return FPS;
	}
	//returns the TPS
	public static int getTPS(){
		return TPS;
	}
	//======================================================================CREATE
  //initializes the main loop and runs trying to get TARGET_TPS and TARGET_FPS
  public void run(){
    MainManager.initialize();
		while( isRunning ){
			actualNanosecond = System.nanoTime();
			if ( actualNanosecond - lastNanosecondPaint > TARGET_TIME_BETWEEN_FRAMES ){
				//========================updateThings
        MainManager.nextFrame();
				lastNanosecondPaint = System.nanoTime();
				preFPS ++;
			}
      if ( actualNanosecond - lastNanosecondTick > TARGET_TIME_BETWEEN_TICKS && preTPS < TARGET_TPS - 1 ){
        //========================updateThings
        MainManager.nextTick();
        lastNanosecondTick = System.nanoTime();
        preTPS ++;
      }
      if( actualNanosecond - lastSecond >= SEC_IN_NANOSEC ){
        lastSecond = System.nanoTime();
        TPS = preTPS;
        FPS = preFPS;
        preTPS = 0;
        preFPS = 0;
				System.out.println("FPS: "+FPS+" TPS: "+TPS);
      }
			while ( actualNanosecond - lastNanosecondPaint < TARGET_TIME_BETWEEN_FRAMES  && actualNanosecond - lastNanosecondTick < TARGET_TIME_BETWEEN_TICKS ){
        Thread.yield();
        actualNanosecond = System.nanoTime();
      }
		}
	}
}
