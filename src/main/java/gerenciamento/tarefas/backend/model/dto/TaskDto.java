package gerenciamento.tarefas.backend.model.dto;

import lombok.Data;

@Data
public class TaskDto {

    private String title;
    private String description;
    private String deadline;
    private String department;
    private String personDocument;

}
