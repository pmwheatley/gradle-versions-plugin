package net.skyscanner.gradle.skg.plugin.reporter.result

import groovy.transform.TupleConstructor

@TupleConstructor
class VersionAvailable {
  String release
  String milestone
  String integration
}
