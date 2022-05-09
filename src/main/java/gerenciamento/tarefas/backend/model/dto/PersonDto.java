package gerenciamento.tarefas.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
@Data
public class PersonDto {
    @NotBlank
    @JsonProperty("Nome")
    private String name;
    @NotBlank
    @JsonProperty("Docuemnto (CPF) ")
    private String document;
    @JsonProperty("Departamento")
    private String department;


}
