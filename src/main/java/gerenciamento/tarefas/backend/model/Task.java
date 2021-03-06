package gerenciamento.tarefas.backend.model;

import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;


@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Calendar startTask;
    private int departments;
    private Long duration;
    private TaskStatus status = TaskStatus.CLOSED;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

}
