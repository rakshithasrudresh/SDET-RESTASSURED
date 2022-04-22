package CommonLibraries;

import java.util.Random;

public class JavaLibrary 
{
	/*
	 * this method generates a random number for every execution
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}
}
