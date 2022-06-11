
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.1.2"

lazy val bazar = (project in file("."))
  .settings(name := "bazar")
  .settings(libraryDependencies ++= Deps.all)
