name := "optparse"

organization := "org.fud"

version := "1.0-si-e1d1c74"

scalaVersion := "2.9.1"

scalacOptions ++= Seq(
    "-deprecation"
)

javacOptions ++= Seq(
    "-target 1.5"
)

//              --- Publishing ---

publishMavenStyle := true

publishTo <<= (version) {
    version: String =>
        val nexus = "http://infra.alpha.spotinfluence.com:8088/nexus/content/repositories/"
        if (version.trim.endsWith("SNAPSHOT")) Some("nexus snapshots" at nexus+"snapshots/")
        else                                   Some("nexus releases" at nexus+"thirdparty/")
}

credentials += Credentials(Path.userHome / ".m2" / "credentials.nexus")
