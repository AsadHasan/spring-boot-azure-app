package org.example.spring_azure_app.router;

import org.example.spring_azure_app.entities.TestRun;
import org.example.spring_azure_app.entities.repositories.TestRunRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final TestRunRepository testRunRepository;

    public Controller(TestRunRepository testRunRepository) {
        this.testRunRepository = testRunRepository;
    }

    @PostMapping(path = "/testrun")
    public void createTestRunResult(@RequestBody TestRun testRun) {
        testRunRepository.save(testRun);
    }

    @PutMapping(path = "/testrun/{testRunId}")
    public void updateTestRunResult(@RequestBody TestRun testRun, @PathVariable int testRunId) {
        testRunRepository.findById(testRunId)
                .map(run -> {
                    run.setResult(testRun.getResult());
                    return testRunRepository.save(run);
                });
    }

    @GetMapping(path = "/testruns")
    public List<TestRun> getTestRunResults() {
        return testRunRepository.findAll();
    }

    @GetMapping(path = "/testrun/{testRunId}")
    public TestRun getTestRunResult(@PathVariable int testRunId) {
        return testRunRepository.findById(testRunId)
                .orElseThrow(() -> new TestRunNotFoundException(testRunId));
    }

    @DeleteMapping(path = "/testrun/{testRunId}")
    public void deleteTestRunResult(@PathVariable int testRunId) {
        testRunRepository.deleteById(testRunId);
    }
}
