package si.urbas.sbt.csharp

import sbt._
import sbt.Keys._
import si.urbas.sbt.compiler.Compiler

trait CSharpPluginKeys {

  val CSharp = config("csharp")

  val cSharpCompiler = SettingKey[Compiler]("compiler").in(CSharp)
  val cSharpSourceDirectory = sourceDirectory.in(CSharp)
  val cSharpCompile = compile.in(CSharp)
  val cSharpTarget = target.in(CSharp)
  val cSharpFrameworkVersion = SettingKey[String]("frameworkVersion").in(CSharp)
  val cSharpPlatform = SettingKey[String]("platform").in(CSharp)
  val cSharpProfile = SettingKey[String]("profile").in(CSharp)
  val cSharpCrossTarget = crossTarget.in(CSharp)
  val cSharpCompiledOutputDir = SettingKey[File]("compiledOutputDir").in(CSharp)
  val cSharpCompiledOutputFile = SettingKey[File]("compiledOutputFile").in(CSharp)

}
