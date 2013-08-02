name := "My awesome project"

version := "1.0"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "1.9.1" % "test" withSources() withJavadoc()
)
