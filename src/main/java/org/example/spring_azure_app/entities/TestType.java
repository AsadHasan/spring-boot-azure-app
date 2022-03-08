package org.example.spring_azure_app.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.example.spring_azure_app.entities.enums.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TestSuite> suites;
}
