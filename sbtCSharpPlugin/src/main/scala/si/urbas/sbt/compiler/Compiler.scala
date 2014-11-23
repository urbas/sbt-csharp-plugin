package si.urbas.sbt.compiler

import java.io.File

import sbt.Logger
import sbt.inc.Analysis

trait Compiler {

  def compile(params: CompileParameters): Analysis

}
