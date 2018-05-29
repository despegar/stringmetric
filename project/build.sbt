lazy val commonSettings = Seq(
  name := "stringmetric",
  organization := "com.despegar.vr",
  publishMavenStyle := true,
  publishTo := Some("Nexus releases" at "http://nexus.despegar.it:8080/nexus/content/repositories/releases/"),
  resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"),
  scalaVersion := "2.12.4"
)

lazy val core = (project in  file("core")).
  settings(
    commonSettings,
    libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.4" % "test"),
    name := "stringmetric-core"
  )

lazy val cli = (project in file("cli")).
  settings(
    commonSettings,
    libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.4" % "test"),
    name := "stringmetric-cli"
  ).dependsOn(core)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    crossScalaVersions := Seq("2.12.4", "2.11.1", "2.10.4"),
    crossVersion := CrossVersion.binary,
    version := "0.27.5"
  ).aggregate(core, cli)

