package org.example.spring_azure_app.router;

public class TestRunNotFoundException extends RuntimeException {
    public TestRunNotFoundException(int testRunId) {
        super("Test run with Id " + "'" + testRunId + "' not found");
    }
}