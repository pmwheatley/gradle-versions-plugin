package net.skyscanner.gradle.skg.plugin.reporter.result

import groovy.transform.TupleConstructor

/**
 * A project's dependency
 */
@TupleConstructor(includeFields = true)
class Dependency {
  String name
  String group
  String version
}
