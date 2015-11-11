package com.github.benmanes.gradle.versions.reporter

import com.github.benmanes.gradle.versions.reporter.result.Result
import com.github.benmanes.gradle.versions.reporter.result.SKGResult

import groovy.json.JsonBuilder
import groovy.transform.TupleConstructor
import groovy.transform.TypeChecked

import org.yaml.snakeyaml.Yaml

/**
 * A json reporter for the dependency updates results.
 *
 * @author Zenedith (zenedith@wp.pl)
 */
@TypeChecked
@TupleConstructor(callSuper = true, includeSuperProperties = true, includeSuperFields = true)
class SKGReporter extends AbstractReporter {

  String yaml_path

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
