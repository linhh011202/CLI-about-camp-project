package main.utils;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

public class ExcetionHandling {

    public static void a() {

    try {

      // code that generate exception
      int divideByZero = 5 / 0;
      System.out.println("Rest of code in try block");
    }
    
    catch (ArithmeticException e) {
      System.out.println("ArithmeticException => " + e.getMessage());
    }
  }
}


//



