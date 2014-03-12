package com.github.hexx.normal

import sbt._
import sbt.Keys._

import com.typesafe.sbt.web.SbtWebPlugin.WebKeys

object SbtListAssetsPlugin extends Plugin {
  object ListAssetsKeys {
    val listAssets = taskKey[Unit]("List all assets.")
  }

  import WebKeys._
  import ListAssetsKeys._

  lazy val listAssetsSettings: Seq[Setting[_]] = Seq(
    listAssets := (unmanagedSources in Assets).value foreach (f => streams.value.log.info(f.getName()))
  )
}
