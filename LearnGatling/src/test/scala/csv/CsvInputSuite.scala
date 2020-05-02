package csv

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class CsvInputSuite extends Simulation {

  val urlRandom = csv("data/UrlData.csv").random
  val urlCircular = csv("data/UrlData.csv").circular

  val scenarionRandom = scenario("scenarionRandom").feed(urlRandom).exec(CsvInputScenario.scenarionHttpGet)
  val scenarionCircular = scenario("scenarionCircular").feed(urlCircular).exec(CsvInputScenario.scenarionHttpGet)

  setUp(
    scenarionRandom.inject(atOnceUsers(1)),
    scenarionCircular.inject(atOnceUsers(1))
  )

}

