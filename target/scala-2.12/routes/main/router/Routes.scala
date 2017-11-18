
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mixax256/fibonacci-api/conf/routes
// @DATE:Sat Nov 18 16:41:08 MSK 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FibonacciNumbersController_1: controllers.FibonacciNumbersController,
  // @LINE:10
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FibonacciNumbersController_1: controllers.FibonacciNumbersController,
    // @LINE:10
    Assets_0: controllers.Assets
  ) = this(errorHandler, FibonacciNumbersController_1, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FibonacciNumbersController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FibonacciNumbersController.getInfo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """calc""", """controllers.FibonacciNumbersController.calc(number:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FibonacciNumbersController_getInfo0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FibonacciNumbersController_getInfo0_invoker = createInvoker(
    FibonacciNumbersController_1.getInfo(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FibonacciNumbersController",
      "getInfo",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_FibonacciNumbersController_calc1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("calc")))
  )
  private[this] lazy val controllers_FibonacciNumbersController_calc1_invoker = createInvoker(
    FibonacciNumbersController_1.calc(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FibonacciNumbersController",
      "calc",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """calc""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FibonacciNumbersController_getInfo0_route(params@_) =>
      call { 
        controllers_FibonacciNumbersController_getInfo0_invoker.call(FibonacciNumbersController_1.getInfo())
      }
  
    // @LINE:7
    case controllers_FibonacciNumbersController_calc1_route(params@_) =>
      call(params.fromQuery[Int]("number", None)) { (number) =>
        controllers_FibonacciNumbersController_calc1_invoker.call(FibonacciNumbersController_1.calc(number))
      }
  
    // @LINE:10
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
