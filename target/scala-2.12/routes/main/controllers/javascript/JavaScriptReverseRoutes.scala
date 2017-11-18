
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mixax256/fibonacci-api/conf/routes
// @DATE:Sat Nov 18 16:41:08 MSK 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseFibonacciNumbersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FibonacciNumbersController.getInfo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def calc: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FibonacciNumbersController.calc",
      """
        function(number0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "calc" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("number", number0)])})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
