package gerenciamento.tarefas.backend.service;

import gerenciamento.tarefas.backend.ConfigTest;
import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

public class PersonServiceTest extends ConfigTest {

    @MockBean
    private PersonRespository personRespository;
    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private PersonService personService;

    @Test
    public void deveRemoverUmaPessoa() throws Exception {
        Long id = 1L;

        Optional<Person> person = Optional.of(createPerson());
        Mockito.when(personRespository.findById(ArgumentMatchers.eq(id))).thenReturn(person);

        personService.deletePersonById(id);

    }

    private Person createPerson() {
        Person person = Mockito.mock(Person.class);
        return person;
    }
}
