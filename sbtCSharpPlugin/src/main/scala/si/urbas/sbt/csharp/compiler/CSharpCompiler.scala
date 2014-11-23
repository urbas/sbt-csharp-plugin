package si.urbas.sbt.csharp.compiler

import java.io.File

import sbt._
import sbt.inc.Analysis
import si.urbas.sbt.compiler.{CompilationOutputFile, SourceDirectory, CompileParameters, Compiler}

class CSharpCompiler extends Compiler {

  private val compilerPath = "C:/Windows/Microsoft.NET/Framework/v4.0.30319/csc.exe"

  override def compile(params: CompileParameters): Analysis = {
    val sourceDir = extractSourceDirectory(params)
    val outputFile = extractOutputFile(params)
    outputFile.getParentFile.mkdirs()
    Process(
      Seq(
        compilerPath,
        "/out:\"" + outputFile.getCanonicalPath + "\"",
        "/recurse:*.cs"
      ),
      sourceDir
    ).!(params.logger)
    Analysis.Empty
  }

  private def extractSourceDirectory(params: CompileParameters): File = {
    params.sources match {
      case SourceDirectory(sourceDir) =>
        sourceDir
      case sourceDir =>
        throw new UnsupportedOperationException(s"This compiler does not support '$sourceDir' sources.")
    }
  }

  private def extractOutputFile(params: CompileParameters): File = {
    params.output match {
      case CompilationOutputFile(outputFile) =>
        outputFile
      case outputFile =>
        throw new UnsupportedOperationException(s"This compiler does not support '$outputFile' output.")
    }
  }
}
