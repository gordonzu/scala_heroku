error id: 
file://<WORKSPACE>/app/controllers/HomeController.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
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
    database.
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: 