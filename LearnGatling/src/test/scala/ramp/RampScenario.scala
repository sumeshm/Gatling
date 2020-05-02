package ramp

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object RampScenario {

  val scenarionHttpGet = scenario("Http-GET")
    .exec(
      http("SimpleGet")
        .get("${URL}")
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .check(status.is(200))
        .check(responseTimeInMillis.saveAs("execLatency"))
        .check(bodyString.saveAs("HTTP-Response")
      )
    )
    .exec(session => {
      // extract previous session data
      // also add data for next session
      session.set("key", "value")
      var responseBody = session("HTTP-Response").as[String]
      System.out.println("####### responseBody=" + responseBody.size)
      session;
    })
    .pause(1)
}

