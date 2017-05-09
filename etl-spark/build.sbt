lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    resolvers += "Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository",
    name := "etl-spark",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
      "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided",
      "org.apache.spark" %% "spark-mllib" % "2.1.0" % "provided"
    )
  )


