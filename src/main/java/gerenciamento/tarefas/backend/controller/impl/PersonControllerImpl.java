package gerenciamento.tarefas.backend.controller.impl;

import gerenciamento.tarefas.backend.controller.PersonController;
import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import gerenciamento.tarefas.backend.model.response.MessageResponse;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.repository.TaskRepository;
import gerenciamento.tarefas.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;
    private final PersonRespository personRespository;
    private final TaskRepository taskRepository;


    @Override
    public ResponseEntity<?> savePerson(PersonDto payload) {
        try {
            var person = personService.personConverter(payload);
            this.personService.savePerson(person);
            return new ResponseEntity<>(MessageResponse.getSuccessMessage(), HttpStatus.CREATED);

        } catch (NumberFormatException n){
            n.printStackTrace();
            return new ResponseEntity<>(MessageResponse.getDepartmentNotFound(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(MessageResponse.getErroMessage(),HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity findPerson(Long id) {
        try {
            var person = personService.findPersonById(id);
            var personResponse = personService.personConverter(person.get());
            return new ResponseEntity<>(personResponse,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(MessageResponse.getPersonNotFoundMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> deletePerson(Long id) {
        try {
            this.personService.deletePersonById(id);
            return new ResponseEntity<>(MessageResponse.getSuccessDeleteMessage(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(MessageResponse.getErroMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public ResponseEntity updatePerson(Long id, PersonDto payload) {
       try {
           var person = this.personService.personConverter(payload);
           this.personService.updatePersonById(id, person);
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(MessageResponse.getErroMessage(), HttpStatus.NOT_FOUND);
       }

    }

    @Override
    public ResponseEntity personInTask(PersonDto payload, Long id) throws Exception {
        try {
            var person = personService.personConverter(payload);
            this.personService.personIntoTask(person, id);
            return new ResponseEntity(MessageResponse.getAddPersonInTask(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(MessageResponse.getAddPersonInTaskError(),HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @Override
    public ResponseEntity findAllTasksWithPerson() throws Exception {
        return new ResponseEntity(this.personService.findAllTasks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity findAll() throws Exception {
        return new ResponseEntity(this.personRespository.findAll(), HttpStatus.OK);
    }
}
