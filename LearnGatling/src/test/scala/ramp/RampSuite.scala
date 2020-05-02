package ramp

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class RampSuite extends Simulation {

  // feeder data
  val urlRandom = csv("data/UrlData.csv").random
  val urlCircular = csv("data/UrlData.csv").circular

  // vm argument data
  var userCount = Integer.getInteger("userCount", 1).toInt.toDouble
  var rampUpDuration = Integer.getInteger("rampUpDuration", 1).toInt.toDouble
  var peakDuration = Integer.getInteger("peakDuration", 2).toInt.toDouble
  var rampDownDuration = Integer.getInteger("rampDownDuration", 1).toInt.toDouble

  // scenarios
  val scenarionRandom = scenario("scenarionRandom")
                            .feed(urlRandom)
                            .exec(RampScenario.scenarionHttpGet)
  val scenarionCircular = scenario("scenarionCircular")
                            .feed(urlCircular)
                            .exec(RampScenario.scenarionHttpGet)

  System.out.println("####### userCount=" + userCount);
  System.out.println("####### rampUpDuration=" + rampUpDuration);
  System.out.println("####### peakDuration=" + peakDuration);
  System.out.println("####### rampDownDuration=" + rampDownDuration);

  // execution details
  if (userCount > 0 && rampUpDuration > 0 && peakDuration > 0 && rampDownDuration > 0) {
    
    setUp(
      scenarionRandom.inject(
          rampUsersPerSec(0.1) to userCount  during(rampUpDuration minutes),
          constantUsersPerSec(userCount)     during(peakDuration minutes) ,
          rampUsersPerSec(userCount) to 0.1  during(rampDownDuration minutes)
      ),
      scenarionCircular.inject(
          rampUsersPerSec(0.1) to userCount  during(rampUpDuration minutes),
          constantUsersPerSec(userCount)     during(peakDuration minutes) ,
          rampUsersPerSec(userCount) to 0.1  during(rampDownDuration minutes)
      )
    )
  } else {
	  System.out.println("####### STOP, failed to meet conditions");
  }

}

