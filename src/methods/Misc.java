package methods;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Misc{
	//div and mult to make a mult()
	public static int makeMultOf(int val,int mult){
		return (val/mult)*mult;
	}
	//checks if in range
	public static boolean isInRange(int val, int from, int to){
		return from <= val && val < to;
	}
	//checks if in range if not it return the nearest lim
	private int isInRangeOrLim(int val, int from, int to){
		if(val < from)	return from;
		if(val > to)		return to;
		return val;
	}
	//return true if is int
	public static boolean IsInteger(String s){
		try{
			Integer.parseInt(s);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//returs the int "val" if is bigger than "min" and "min" if not
	public static int retMinOrVal(int min, int val){
		if(min>val){
			return min;
		}
		else{
			return val;
		}
	}
	//returs the int "val" if is smaller than "max" and "max" if not
	public static int retMaxOrVal(int max, int val){
		if(max<val)
			return max;
		else
			return val;
	}
	//returns true if (x,y) is included in the rectagle
	public static boolean isInside(int x, int y, int tX, int tY, int tWidth, int tHeight){
		return x>= tX && x<= tX + tWidth && y>= tY && y<= tY + tHeight;
	}
	//returs the BufferedImageimage instance of the thing on the path
	public static BufferedImage getImage(String path){
		BufferedImage res= null;
		try{
			res = ImageIO.read(Misc.class.getResource(path));
		}catch(IOException e){}
		return res;
	}
}
