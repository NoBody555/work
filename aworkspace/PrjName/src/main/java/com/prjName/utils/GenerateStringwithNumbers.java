package com.prjName.utils;

import java.util.Random;

public class GenerateStringwithNumbers {
public static String generateStringWithNums(){
	String salt="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";	
    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();
    while(sb.length()<11){
 	   int index = (int) (rnd.nextFloat()*salt.length());
 	   sb.append(salt.charAt(index));
    }
    return sb.toString();
}
public static int generateRandomNumber(){
	Random rnd = new Random();
   
    return  1000000 + rnd.nextInt(7000000);
}
}
