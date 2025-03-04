package com.classgen.classgen.service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.Diagnostic;
import java.io.StringWriter;
import java.util.Collections;

public class CodeCompiler {

    public static class CompilationResult {
        private final int status; // 0 for success, 1 for failure
        private final String output; // Error messages or success output

        public CompilationResult(int status, String output) {
            this.status = status;
            this.output = output;
        }

        public int getStatus() {
            return status;
        }

        public String getOutput() {
            return output;
        }
    }

    public static CompilationResult compileCode(String code) {
        // Get the Java Compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            return new CompilationResult(1, "No Java compiler available. Are you running this on a JDK?");
        }

        // Set up the diagnostics collector to capture compilation errors
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        // Define a file manager and create a source file from the input code
        JavaFileObject file = new InMemoryJavaFile("Test", code);

        // Perform the compilation
        StringWriter writer = new StringWriter();
        boolean success = compiler.getTask(writer, null, diagnostics, null, null, Collections.singletonList(file)).call();

        // Collect diagnostics if compilation fails
        if (!success) {
            StringBuilder errorMessages = new StringBuilder();
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                errorMessages.append("Error on line ")
                        .append(diagnostic.getLineNumber())
                        .append(": ")
                        .append(diagnostic.getMessage(null))
                        .append("\n");
            }
            return new CompilationResult(1, errorMessages.toString());
        }

        return new CompilationResult(0, "Compilation succeeded");
    }

    // A simple class to represent Java source code as a file object in memory
    static class InMemoryJavaFile extends SimpleJavaFileObject {
        private final String code;

        public InMemoryJavaFile(String className, String code) {
            super(java.net.URI.create("string:///" + className.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension),
                    JavaFileObject.Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

}
