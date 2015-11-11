package net.skyscanner.gradle.skg.plugin.reporter.result

import groovy.transform.TupleConstructor

/**
 * A group of dependencies
 *
 */
@TupleConstructor
class SKGDependenciesGroup {
	List<SKGDependency> dependencies = []
	List<SKGDependencyOutdated> outdated = []
}
