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

    def id = project.path
    def name = project.name

    if (yaml_path.length() > 0) {
      File configFile = new File(yaml_path)
      Yaml yaml = new Yaml();

      Map config = (Map) yaml.load(configFile.newReader())
      List<Map> service = (List<Map>) config.get("services")
      
      id = service[0].get("id").toString()
      name = service[0].get("name").toString()
    }

    def new_result = new SKGResult(id: id, name: name).initFromResult(result)
  	return new_result
  }

  @Override
  def getFileName() {
    return 'SKG_report.json'
  }
}
