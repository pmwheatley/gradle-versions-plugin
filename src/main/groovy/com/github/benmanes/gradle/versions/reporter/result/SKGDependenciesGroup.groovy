package com.github.benmanes.gradle.versions.reporter.result

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
