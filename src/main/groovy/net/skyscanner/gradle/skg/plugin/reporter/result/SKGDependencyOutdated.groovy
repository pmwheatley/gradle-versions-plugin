package net.skyscanner.gradle.skg.plugin.reporter.result

import groovy.transform.TupleConstructor

@TupleConstructor(callSuper = true, includeSuperProperties = true, includeSuperFields = true)
class SKGDependencyOutdated extends SKGDependency {
  String latest_version
}
