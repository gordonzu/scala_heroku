package controllers

import javax.inject._
import play.api._
import play.api.db.Database
import play.api.mvc._


@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents,
                               val database: Database) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def db() = Action { implicit request: Request[AnyContent] =>
    database.withConnection { connection => 
      val statement = connection.createStatement() 
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)")
      statement.executeUpdate("INSERT INTO ticks VALUES (now())")

      val output = new StringBuilder();
      val resultSet = statement.executeQuery("SELECT tick FROM ticks")
      while (resultSet.next()) {
        output.append("Read from DB: " + resultSet.getTimestamp("tick") + "\n")
      }
      Ok(output.toString())
    }
  }
}
    
