
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mixax256/fibonacci-api/conf/routes
// @DATE:Sat Nov 18 16:41:08 MSK 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
