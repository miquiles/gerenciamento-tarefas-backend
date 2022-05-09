package gerenciamento.tarefas.backend.service;

import gerenciamento.tarefas.backend.ConfigTest;
import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.repository.TaskRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PersonServiceTest extends ConfigTest {

    @Mock
    private PersonRespository personRespository;
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private PersonService personService;

    private Person entity;

    @BeforeEach
    void setup(){
        entity = new Person();
    }

    @Test
    @DisplayName("deve salvar uma pessoa e retornar a mesma")
    public void deveSalvarUmaPessoa() throws Exception {


        when(personRespository.save(any())).thenReturn(entity);

        var retorno = personService.savePerson(entity);

        assertThat(retorno).isNotNull();
        assertThat(retorno.getDocument()).isEqualTo(entity.getDocument());
        assertThat(retorno.getDepartments()).isEqualTo(entity.getDepartments());
        assertThat(retorno.getName()).isEqualTo(entity.getName());


    }

    @Test
    @DisplayName("deve retornar a pessoa pelo id")
    public void deveRetornarPessoaPorId() throws Exception {
        Long idPerson = 1L;
        when(personRespository.findById(anyLong())).thenReturn(Optional.ofNullable(entity));

        var retorno = personService.findPersonById(idPerson);
        assertThat(retorno).isNotNull();
        assertThat(retorno.get().getName()).isEqualTo(entity.getName());
        assertThat(retorno.get().getDepartments()).isEqualTo(entity.getDepartments());
        assertThat(retorno.get().getDocument()).isEqualTo(entity.getDocument());


    }




    }
