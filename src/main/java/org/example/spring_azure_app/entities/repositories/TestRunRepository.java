package org.example.spring_azure_app.entities.repositories;

import org.example.spring_azure_app.entities.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRunRepository extends JpaRepository<TestRun, Integer> {
}
