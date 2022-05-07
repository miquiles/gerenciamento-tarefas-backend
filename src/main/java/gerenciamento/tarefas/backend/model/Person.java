package gerenciamento.tarefas.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;

    @OneToOne(cascade=CascadeType.ALL)
    private Department department;

    @OneToMany(mappedBy = "person", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public Person(String name, String document) {
        this.name = name;
    }


}
