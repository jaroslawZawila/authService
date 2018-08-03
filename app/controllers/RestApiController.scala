package controllers

import akka.actor.ActorSystem
import auth.DefaultEnv
import com.mohiva.play.silhouette.api.Silhouette
import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

class RestApiController @Inject()(silhouette: Silhouette[DefaultEnv], cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  def indexx = silhouette.SecuredAction { implicit request =>
    Ok("HELLO SECURE WORLD")
  }

  def insecureIndex = silhouette.UnsecuredAction { implicit request =>
    Ok("HELLO IN-SECURE WORLD")
  }


}
