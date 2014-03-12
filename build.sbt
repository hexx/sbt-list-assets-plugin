val commonSettings = Seq(
  sbtPlugin := true,
  organization := "com.github.hexx",
  version := "0.1.0-SNAPSHOT",
  resolvers += Classpaths.sbtPluginSnapshots,
  addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.0.0-SNAPSHOT")
)

lazy val normal = project.settings(
  commonSettings :+ (name := "sbt-list-assets-plugin-normal"): _*
)

lazy val auto = project.settings(
  commonSettings :+ (name := "sbt-list-assets-plugin-auto"): _*
)
