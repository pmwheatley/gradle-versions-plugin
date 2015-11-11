package net.skyscanner.gradle.skg.plugin.reporter

import net.skyscanner.gradle.skg.plugin.reporter.result.Result
import net.skyscanner.gradle.skg.plugin.reporter.result.SKGResult

import groovy.json.JsonBuilder
import groovy.transform.TupleConstructor
import groovy.transform.TypeChecked

/**
 * A json reporter for the dependency updates results.
 *
 * @author Zenedith (zenedith@wp.pl)
 */
@TypeChecked
@TupleConstructor(callSuper = true, includeSuperProperties = true, includeSuperFields = true)
class SKGReporter extends AbstractReporter {

  def write(printStream, Result result) {
    printStream.println new JsonBuilder(reformat_result(result)).toPrettyString().stripMargin()
  }

  def reformat_result(Result result) {
    def new_result = new SKGResult().initFromResult(result)
  	return new_result
  }

  @Override
  def getFileName() {
    return 'SKG_report.json'
  }
}
