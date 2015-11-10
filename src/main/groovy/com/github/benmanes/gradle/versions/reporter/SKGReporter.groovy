package com.github.benmanes.gradle.versions.reporter

import com.github.benmanes.gradle.versions.reporter.result.Result

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
  	return result
  }

  @Override
  def getFileName() {
    return 'SKG_report.json'
  }
}
