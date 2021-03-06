
lazy val commonSettings = Seq(
  organization := "com.despegar.vr",
  publishMavenStyle := true,
  publishTo := Some("Nexus releases" at "http://nexus.despegar.it:8080/nexus/content/repositories/releases/"),
  resolvers += Opts.resolver.mavenLocalFile,
  resolvers += Resolver.mavenLocal,
  resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  resolvers += "Nexus Public Repository" at "http://vmtilcara.servers.despegar.it:8080/nexus/content/groups/public",
  resolvers += "Nexus Snapshots Repository" at "http://vmtilcara.servers.despegar.it:8080/nexus/content/repositories/snapshots",
  resolvers += "Nexus Proxies Repository" at "http://vmtilcara.servers.despegar.it:8080/nexus/content/groups/proxies",
  scalaVersion := "2.12.4"
)

lazy val core = (project in  file("core")).
  settings(
    commonSettings,
    libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.4" % "test"),
    name := "stringmetric-core",
    releaseVersionFile := file(name.value + "/version.sbt")
  )

lazy val cli = (project in file("cli")).
  settings(
    commonSettings,
    libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.4" % "test"),
    name := "stringmetric-cli",
    releaseVersionFile := file(name.value + "/version.sbt")
  ).dependsOn(core)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    name := "stringmetric"
  ).aggregate(core, cli)

