package com.github.hexx.auto

import sbt._
import sbt.Keys._

import com.typesafe.sbt.web.SbtWebPlugin

object SbtListAssetsPlugin extends AutoPlugin {
  def select = SbtWebPlugin

  object ListAssetsKeys {
    val listAssets = taskKey[Unit]("List all assets.")
  }

  import SbtWebPlugin.WebKeys._
  import ListAssetsKeys._

  override def projectSettings = Seq(
    listAssets := (unmanagedSources in Assets).value foreach (f => streams.value.log.info(f.getName()))
  )
}
