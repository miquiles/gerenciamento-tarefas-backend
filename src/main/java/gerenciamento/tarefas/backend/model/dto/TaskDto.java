package gerenciamento.tarefas.backend.model.dto;

import gerenciamento.tarefas.backend.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String title;
    private String description;
    private String deadline;
    private String department;
    private String personDocument;
    private Person person;

}
