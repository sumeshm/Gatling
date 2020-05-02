package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object BasicScenario {

  var googleURL = "https://www.google.com"

  val scenarionV1 = scenario("Http-GET")
    .exec(
      http("SimpleGet")
        .get(googleURL)
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .check(status.is(200))
        .check(responseTimeInMillis.saveAs("execLatency"))
        .check(bodyString.saveAs("Google-Response")
      )
    )
    .exec(session => {
      session.set("key", "value");
      session;
    })
}

