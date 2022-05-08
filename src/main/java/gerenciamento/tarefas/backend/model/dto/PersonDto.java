package gerenciamento.tarefas.backend.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
@Data
public class PersonDto {
    @NotBlank
    private String name;
    @NotBlank
    private String document;
    private String department;


}
