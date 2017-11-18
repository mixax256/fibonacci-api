
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mixax256/fibonacci-api/conf/routes
// @DATE:Sat Nov 18 16:41:08 MSK 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseFibonacciNumbersController FibonacciNumbersController = new controllers.ReverseFibonacciNumbersController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseFibonacciNumbersController FibonacciNumbersController = new controllers.javascript.ReverseFibonacciNumbersController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
