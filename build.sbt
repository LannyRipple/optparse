name := "optparse"

organization := "org.fud"

version := "1.2-si-e1d1c74"

scalaVersion := "2.10.2"

scalacOptions ++= Seq(
    "-deprecation"
)

javacOptions ++= Seq(
    "-target 1.6"
)

//              --- Publishing ---

publishMavenStyle := true

publishTo <<= (version) {
    version: String =>
        val nexus = "http://maven.talkrank.com:8081/nexus/content/repositories/"
        if (version.trim.endsWith("SNAPSHOT")) Some("nexus snapshots" at nexus+"snapshots/")
        else                                   Some("nexus releases" at nexus+"thirdparty/")
}

credentials += Credentials(Path.userHome / ".m2" / "credentials.nexus")
