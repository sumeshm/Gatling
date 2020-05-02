package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSuite extends Simulation {

  val scenarion1 = scenario("scenarionV1").exec(BasicScenario.scenarionHttpGet).pause(2)
  val scenarion2 = scenario("scenarionV1Copy").exec(BasicScenario.scenarionHttpGet).pause(2)

  setUp(
    scenarion1.inject(atOnceUsers(1)),
    scenarion2.inject(atOnceUsers(1))
  )

}

