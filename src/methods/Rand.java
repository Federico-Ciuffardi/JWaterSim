package methods;
import java.util.Random;
public class Rand{
	private static Random randomizer = new Random();
	private static String[] CharBeginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
			"Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
			"Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
			"Mar", "Luk" };
	private static String[] CharMiddle = { "air", "ir", "mi", "sor", "mee", "clo",
			"red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
			"marac", "zoir", "slamar", "salmar", "urak" };
	private static String[] CharEnd = { "d", "ed", "ark", "arc", "es", "er", "der",
			"tron", "med", "ure", "zur", "cred", "mur" };
//return a random naem
	public static String nextCharName(){
		return CharBeginning[randomizer.nextInt(CharBeginning.length)] +
				 	 CharMiddle[randomizer.nextInt(CharMiddle.length)]+
				   CharEnd[randomizer.nextInt(CharEnd.length)];
	}
//return a random naem
	public static String nextEnemyName(){
		return CharBeginning[randomizer.nextInt(CharBeginning.length)] +
				 	 CharMiddle[randomizer.nextInt(CharMiddle.length)]+
				   CharEnd[randomizer.nextInt(CharEnd.length)];
	}
	//returns a random int in [min,max]
  public static int nextInt(int min, int max){
		if( (max - min) + 1 >= 0 ){
	    int randomNum = randomizer.nextInt((max - min) + 1) + min;
			return randomNum;
		}else{
			return 0;
		}
  }
	public static int propVarInt(int val, int prop){
		int randomNum = Rand.nextInt(0,prop);
		return  (val*( 100 + randomNum - prop/2 ) ) / 100;
	}
	public static int valVarInt(int val, int var){
		int randomNum = Rand.nextInt(0,var);
		return val + randomNum - var/2;
	}
}
