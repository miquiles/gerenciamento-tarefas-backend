package gerenciamento.tarefas.backend.model;

import gerenciamento.tarefas.backend.model.enums.DepartmentsEnum;
import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


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
    private Date deadline; // prazo final
    private Calendar startTask; // primeiro dia da task iniciada
    private int departments;
    private Date duration; //valor entre o prazo final e a data iniciada.
    private TaskStatus status = TaskStatus.CLOSED;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

}
