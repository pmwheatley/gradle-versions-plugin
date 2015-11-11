package com.github.benmanes.gradle.versions.reporter.result

import groovy.transform.TupleConstructor

/**
 * The result of a dependency update analysis
 */
@TupleConstructor
class SKGResult {

	SKGDependenciesGroup current

	def initFromResult(result) {
		def dependencies = result.current.dependencies
		def outdated = result.outdated.dependencies

		List<SKGDependency> skgDependencies = []
		List<SKGDependencyOutdated> skgOutdated = []

		dependencies.each {
			skgDependencies.add(new SKGDependency(name: "${it.group}:${it.name}", version: it.version))
		}

		outdated.each {
			skgOutdated.add(new SKGDependencyOutdated(name: "${it.group}:${it.name}", version: it.version, latest_version: it.available.release))
		}

		current = new SKGDependenciesGroup(dependencies: skgDependencies, outdated: skgOutdated)
	}
}
