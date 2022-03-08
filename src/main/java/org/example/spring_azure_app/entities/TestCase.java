package org.example.spring_azure_app.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ToString.Exclude
    @JoinColumn(name = "scenario_id")
    private TestScenario scenario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TestRun> testRuns;
}
