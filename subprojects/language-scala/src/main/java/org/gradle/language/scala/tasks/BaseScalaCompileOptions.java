/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.language.scala.tasks;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.compile.AbstractOptions;
import org.gradle.api.tasks.scala.IncrementalCompileOptions;
import org.gradle.api.tasks.scala.ScalaForkOptions;

import java.util.List;

/**
 * Options for Scala platform compilation, excluding any options for compilation with Ant.
 */
public class BaseScalaCompileOptions extends AbstractOptions {

    private static final long serialVersionUID = 0;

    private boolean failOnError = true;

    private boolean deprecation = true;

    private boolean unchecked = true;

    private String debugLevel;

    private boolean optimize;

    private String encoding;

    private boolean force;

    private List<String> additionalParameters;

    private boolean listFiles;

    private String loggingLevel;

    private List<String> loggingPhases;

    private ScalaForkOptions forkOptions = new ScalaForkOptions();

    private IncrementalCompileOptions incrementalOptions = new IncrementalCompileOptions();

    /**
     * Fail the build on compilation errors.
     */
    public boolean isFailOnError() {
        return failOnError;
    }

    public void setFailOnError(boolean failOnError) {
        this.failOnError = failOnError;
    }

    /**
     * Generate deprecation information.
     */
    public boolean isDeprecation() {
        return deprecation;
    }

    public void setDeprecation(boolean deprecation) {
        this.deprecation = deprecation;
    }

    /**
     * Generate unchecked information.
     */
    public boolean isUnchecked() {
        return unchecked;
    }

    public void setUnchecked(boolean unchecked) {
        this.unchecked = unchecked;
    }

    /**
     * Generate debugging information.
     * Legal values: none, source, line, vars, notailcalls
     */
    @Input
    @Optional
    public String getDebugLevel() {
        return debugLevel;
    }

    public void setDebugLevel(String debugLevel) {
        this.debugLevel = debugLevel;
    }

    /**
     * Run optimizations.
     */
    @Input
    public boolean isOptimize() {
        return optimize;
    }

    public void setOptimize(boolean optimize) {
        this.optimize = optimize;
    }

    /**
     * Encoding of source files.
     */
    @Input @Optional
    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Whether to force the compilation of all files.
     * Legal values:
     * - false (only compile modified files)
     * - true (always recompile all files)
     */
    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * Additional parameters passed to the compiler.
     * Each parameter must start with '-'.
     */
    public List<String> getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(List<String> additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    /**
     * List files to be compiled.
     */
    public boolean isListFiles() {
        return listFiles;
    }

    public void setListFiles(boolean listFiles) {
        this.listFiles = listFiles;
    }

    /**
     * Specifies the amount of logging.
     * Legal values:  none, verbose, debug
     */
    public String getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(String loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    /**
     * Phases of the compiler to log.
     * Legal values: namer, typer, pickler, uncurry, tailcalls, transmatch, explicitouter, erasure,
     *               lambdalift, flatten, constructors, mixin, icode, jvm, terminal.
     */
    public List<String> getLoggingPhases() {
        return loggingPhases;
    }

    public void setLoggingPhases(List<String> loggingPhases) {
        this.loggingPhases = loggingPhases;
    }

    /**
     * Options for running the Scala compiler in a separate process. These options only take effect
     * if {@code fork} is set to {@code true}.
     */
    public ScalaForkOptions getForkOptions() {
        return forkOptions;
    }

    public void setForkOptions(ScalaForkOptions forkOptions) {
        this.forkOptions = forkOptions;
    }


    @Nested
    public IncrementalCompileOptions getIncrementalOptions() {
        return incrementalOptions;
    }

    public void setIncrementalOptions(IncrementalCompileOptions incrementalOptions) {
        this.incrementalOptions = incrementalOptions;
    }
}
