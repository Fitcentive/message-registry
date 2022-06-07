name := "message-regsitry"
organization := "io.fitcentive"

scalaVersion := "2.13.8"
version := Option(System.getProperty("version")).getOrElse("1.0.0")

packageOptions += Package.ManifestAttributes(
  "Built-By" -> System.getProperty("user.name"),
  "Build-Jdk" -> System.getProperty("java.version"),
)

startYear := Some(2022)
javacOptions ++= Seq("-source", "1.11", "-target", "1.11", "-Xlint:unchecked", "-encoding", "UTF-8")
scalacOptions ++= Seq("-Ymacro-annotations", "-unchecked", "-deprecation", "-language:_", "-encoding", "UTF-8")
cancelable in Global := true
Global / onChangedBuildSource := ReloadOnSourceChanges

libraryDependencies ++= Seq(
  //Circe
  "io.circe" %% "circe-core"           % "0.14.1",
  "io.circe" %% "circe-generic"        % "0.14.1",
  "io.circe" %% "circe-generic-extras" % "0.14.1",
  "io.circe" %% "circe-parser"         % "0.14.1",
)
