package si.urbas.sbt.compiler

import java.io.File

import sbt.Logger

trait Compiler {

  def compile(logger: Logger, sourceDirectory: File, compiledOutputFile: File): Unit

}
