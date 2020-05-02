package csv

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object CsvInputScenario {

  var googleURL = "https://www.google.com"

  val scenarionHttpGet = scenario("Http-GET")
    .exec(
      http("SimpleGet")
        .get("${URL}")
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .check(status.is(200))
        .check(responseTimeInMillis.saveAs("execLatency"))
        .check(bodyString.saveAs("Google-Response")
      )
    )
    .pause(1)
    .exec(session => {
      session.set("key", "value");
      session;
    })
}

