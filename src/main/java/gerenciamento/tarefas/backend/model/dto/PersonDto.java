package gerenciamento.tarefas.backend.model.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class PersonDto {

    private String name;
    private String document;


}
