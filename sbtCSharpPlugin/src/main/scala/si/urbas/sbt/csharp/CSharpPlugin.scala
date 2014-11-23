package si.urbas.sbt.csharp

import sbt._
import sbt.Keys._
import sbt.inc.Analysis
import sbt.plugins.{CorePlugin, JvmPlugin}
import si.urbas.sbt.compiler.{CompilationOutputFile, SourceDirectory, CompileParameters}
import si.urbas.sbt.csharp.compiler.CSharpCompiler

object CSharpPlugin extends AutoPlugin with CSharpPluginKeys {

  object autoImport extends CSharpPluginKeys

  override def requires: Plugins = super.requires && CorePlugin && JvmPlugin

  override def projectConfigurations: Seq[Configuration] = {
    super.projectConfigurations
  }

  override def projectSettings: Seq[Def.Setting[_]] = {
    super.projectSettings ++ Seq(
      cSharpSourceDirectory := sourceDirectory.in(Compile).value / "cs",
      cSharpCompiler := new CSharpCompiler(),
      cSharpTarget := target.value / "csharp",
      cSharpFrameworkVersion := "v4.0.30319",
      cSharpPlatform := "anycpu",
      cSharpProfile := "debug",
      cSharpCrossTarget := cSharpTarget.value / cSharpFrameworkVersion.value / cSharpPlatform.value / cSharpProfile.value,
      cSharpCompile <<= cSharpCompileTask(),
      cSharpCompiledOutputDir := cSharpCrossTarget.value / "compiled",
      cSharpCompiledOutputFile := cSharpCompiledOutputDir.value / s"${name.value}.exe"
    )
  }

  private def cSharpCompileTask(): Def.Initialize[Task[Analysis]] = {
    Def.task[Analysis] {
      val compileParameters = CompileParameters(
        streams.value.log,
        SourceDirectory(cSharpSourceDirectory.value),
        CompilationOutputFile(cSharpCompiledOutputFile.value)
      )
      cSharpCompiler.value.compile(compileParameters)
    }
  }
}
