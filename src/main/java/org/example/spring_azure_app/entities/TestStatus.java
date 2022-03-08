package org.example.spring_azure_app.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.example.spring_azure_app.entities.enums.Status;

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
public class TestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "result", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TestRun> testRuns;
}
