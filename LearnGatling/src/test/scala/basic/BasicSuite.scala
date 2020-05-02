package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSuite extends Simulation {

  val scenarionV1 = scenario("scenarionV1").exec(BasicScenario.scenarionV1).pause(2)
  val scenarionV1Copy = scenario("scenarionV1Copy").exec(BasicScenario.scenarionV1).pause(2)

  setUp(
    scenarionV1.inject(atOnceUsers(1)),
    scenarionV1Copy.inject(atOnceUsers(1))
  )

}

