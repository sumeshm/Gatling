## Learn how to use Gatling for load testing

[Gatling Doc](https://gatling.io/docs/current/cheat-sheet/)

[Cheat Sheet](https://gatling.io/docs/2.3/cheat-sheet/)

### Commands to run Suite:


```
export JAVA_OPTS="$JAVA_OPTS -D userCount=1 -D rampUpDuration=1 -D peakDuration=2 -D rampDownDuration=1"
```

Basic Suite:

```
mvn gatling:test -Dgatling.simulationClass=basic.BasicSuite
```

CSV Feeder Suite:

```
mvn gatling:test -Dgatling.simulationClass=csv.CsvInputSuite
```

Ramp-Execution Suite:

```
mvn gatling:test -Dgatling.simulationClass=ramp.RampSuite
```

