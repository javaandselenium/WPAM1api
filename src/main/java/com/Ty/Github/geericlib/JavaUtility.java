package com.Ty.Github.geericlib;

import java.util.Random;
/**
 * 
 * @author QSP
 *
 */
public class JavaUtility {
	/**
	 * To generate the random integers
	 * @return
	 */

	public static int getRandomNumb() {
		Random ran=new Random();
		int num = ran.nextInt(2000);
		return num;
	}
	
}
