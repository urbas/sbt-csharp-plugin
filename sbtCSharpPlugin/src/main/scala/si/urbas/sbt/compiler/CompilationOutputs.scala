package si.urbas.sbt.compiler

import java.io.File

trait CompilationOutputs

case class CompilationOutputFile(outputFile: File) extends CompilationOutputs