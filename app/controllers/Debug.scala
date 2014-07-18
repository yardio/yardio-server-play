package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._


object Debug extends Controller {

  def display = Action {
    val prints = Map(
      "None" -> "nope"
    )

    Ok(views.html.debug(prints))
  }

}
