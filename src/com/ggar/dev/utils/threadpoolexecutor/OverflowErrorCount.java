package com.ggar.dev.utils.threadpoolexecutor;

public class OverflowErrorCount {
   public static int count = 0;    
   public static void main(String args[]) {
       try {
    	   System.out.println(++count);
           main(null);
       } catch (StackOverflowError e) {
    	   e.printStackTrace();
    	   System.exit(0);
       }
   }
}
