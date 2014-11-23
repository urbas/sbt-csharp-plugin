package si.urbas.sbt.compiler

import java.io.File

trait CompilationSources

case class SourceDirectory(dir: File) extends CompilationSources