package si.urbas.sbt.csharp.compiler

import java.io.File

import sbt._
import si.urbas.sbt.compiler.Compiler

class CSharpCompiler extends Compiler {

  private val compilerPath = "C:/Windows/Microsoft.NET/Framework/v4.0.30319/csc.exe"

  override def compile(logger: Logger, sourceDirectory: File, compiledOutputFile: File): Unit = {
    compiledOutputFile.getParentFile.mkdirs()
    Process(
      Seq(
        compilerPath,
        "/out:\"" + compiledOutputFile.getCanonicalPath + "\"",
        "/recurse:*.cs"
      ),
      sourceDirectory
    ).!(logger)
  }

}
