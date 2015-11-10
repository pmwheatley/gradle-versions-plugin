package com.github.benmanes.gradle.versions.reporter.result

import groovy.transform.TupleConstructor

/**
 * A project's dependency
 */
@TupleConstructor(includeFields = true)
class SKGDependency {
  String name
  String version
}
