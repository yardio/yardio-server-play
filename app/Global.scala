import play.api.Play
import play.api._
import play.api.mvc._

import controllers._

object Global extends GlobalSettings {
  def default(req: RequestHeader): Handler = super.onRouteRequest(req) getOrElse Action { Results.NotFound }

  override def onStart(app: Application) {
    Logger.info("Application has started")
    Logger.info(Play.current.configuration.underlying.root().render())
  }

  override def onRouteRequest(req: RequestHeader): Option[Handler] = (req.method, req.path) match {
    case ("GET", "/debug") => Option(Debug.display)
    case _ => Option(io.yard.module.core.controllers.YardioController.applyRoute(req, default))
  }
}
