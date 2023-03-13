package cosc201.lab02;

import cosc201.utilities.Timer;

// comment for test commit - Hayden 

/**
 * Lab 2, Experiment 1
 * 
 * a. Look at the times required to compute fibRec(n) for various values of n.
 *    How do these times behave? How large a value of n can you (realistically)
 *    apply this method to?
 * b. Do the other implementations produce the same sequence of values? Aside
 *    from "running the code and checking" are you confident of this (based
 *     on reading the code)?
 * c. How large a value of n can you apply the other methods to in a
 *    reasonable length of time? What's the limiting condition?
 * d. Which of the other methods is "best"?
 * 
 * @author Michael Albert
 */
public class Lab2Exp1 {

  public static void main(String[] args) {
    // Add your code for doing experiments here.
    Timer time = new Timer();
    time.start();
    fibRec(10);
    long timeTaken1 = time.stop();
    System.out.println(timeTaken1);

    // time.start();
    // fibRec(50);
    // long timeTaken2 = time.stop();
    // System.out.println(timeTaken2);

    // time.start();
    // fibRec(100);
    // long timeTaken3 = time.stop();
    // System.out.println(timeTaken3);

    //they grow exponentially larger, realistically you can only apply this to a range of 10
    //as any larger it takes too long

    time.start();
    fibA(10000);
    long timeTaken4 = time.stop();
    System.out.println(timeTaken4);

    time.start();
    fibB(10000);
    long timeTaken5 = time.stop();
    System.out.println(timeTaken5);

    time.start();
    fibC(10000);
    long timeTaken6 = time.stop();
    System.out.println(timeTaken6);

    // they are alike in the respect that the time takes longer with greater values,
    // however the computation is much more efficient 
    // 10000 is the limit and when you get past this you get an integer overflow for the long values
    // the best would be fibA as it has the quickest computational time




    

  }
   
  static long fibRec(int n) {
    if (n <= 1) return 1;
    return fibRec(n-1) + fibRec(n-2);
  }
  
  static long fibA(int n) {
    long a = 1;
    long b = 1;
    for(int i = 0; i < n; i++) {
      long c = a + b;
      a = b;
      b = c;
    }
    return a;
  }
  
  static long fibB(int n) {
    long[] result = new long[n+1];
    result[0] = 1;
    result[1] = 1;
    for(int k = 2; k <= n; k++) {
      result[k] = result[k-1] + result[k-2];
    }
    return result[n];
  }
  
  static long fibC(int n) {
    return fibC(1, 1, n);
  }
  
  static long fibC(int a, int b, int n) {
    if (n == 0) return a;
    return fibC(b, a+b, n-1);
  }
  
}

