package gerenciamento.tarefas.backend.model;

import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String deadline;

    @OneToOne
    private Department department;
    private String duration;
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
