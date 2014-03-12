package com.github.hexx.auto

import sbt._
import sbt.Keys._

import com.typesafe.sbt.web.SbtWebPlugin

object SbtListAssetsPlugin extends AutoPlugin {
  // def select: Plugins = SbtWebPlugin
  def select = Plugins.empty

  object ListAssetsKeys {
    val listAssets = taskKey[Unit]("List all assets.")
  }

  import SbtWebPlugin.WebKeys._
  import ListAssetsKeys._

  override def projectSettings = SbtWebPlugin.webSettings ++ Seq(
    listAssets := (unmanagedSources in Assets).value foreach (f => streams.value.log.info(f.getName()))
  )
}
