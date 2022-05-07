package gerenciamento.tarefas.backend.model;

import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade=CascadeType.ALL)
    private Person person;






}
