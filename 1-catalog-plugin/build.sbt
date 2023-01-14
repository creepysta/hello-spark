//lazy val rootVersion = "0.1.0-SNAPSHOT"
//lazy val supportedScalaVersions = List("2.12.15")
//
//def spark(artifact: String): ModuleID = {
//  "org.apache.spark" %% artifact % "3.2.0"
//}
//
//lazy val buildSettings = Seq(
//  //organization := "com.creepysta.hellospark.catalog",
//  version := rootVersion,
//  scalaVersion := supportedScalaVersions.head,
//  scalacOptions := List("-encoding", "utf8", "-deprecation", "-unchecked"),
//  libraryDependencies ++= Seq(
//    spark("spark-sql") % Provided,
//    spark("spark-hive") % Provided,
//  ),
//  updateOptions := updateOptions.value.withCachedResolution(true),
//  useCoursier := false,
//)
//
//lazy val root = (project in file(".")).settings(
//  inThisBuild(buildSettings),
//  name := "hello-catalog",
//)

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "hello-catalog"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.2.0",
  "org.apache.spark" %% "spark-hive" % "3.2.0"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test

