package com.github.benmanes.gradle.versions.reporter.result

import groovy.transform.TupleConstructor

/**
 * A group of dependencies
 *
 */
@TupleConstructor
class SKGDependenciesGroup {

	String id
	String name

	List<SKGDependency> dependencies = []
	List<SKGDependencyOutdated> outdated = []
}
