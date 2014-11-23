package si.urbas.sbt.compiler

import sbt.Logger

case class CompileParameters(logger: Logger,
                             sources: CompilationSources,
                             output: CompilationOutputs)
