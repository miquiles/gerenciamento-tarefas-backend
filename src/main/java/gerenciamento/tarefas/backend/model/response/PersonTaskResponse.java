package gerenciamento.tarefas.backend.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import gerenciamento.tarefas.backend.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonTaskResponse {
    @JsonProperty("Pessoa")
    private Person person;
    @JsonProperty("departamento")
    private int departments;
    @JsonProperty("Duração da atividade em horas")
    private Long duration;
}
