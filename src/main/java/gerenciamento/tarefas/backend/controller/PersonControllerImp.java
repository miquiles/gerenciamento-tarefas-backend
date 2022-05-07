package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.response.MessageResponse;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.TransactionRequiredException;

@AllArgsConstructor
@RestController
public class PersonControllerImp implements PersonController {

    final PersonService personService;

    @Override
    public ResponseEntity<?> save(PersonDto payload) {
        try {
            var person = personService.personConverter(payload);
            this.personService.savePerson(person);
            return new ResponseEntity<>(MessageResponse.getSuccessMessage(), HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(MessageResponse.getErroMessage(),HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity findPerson(Long id) throws Exception {
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
    public ResponseEntity updatePerson(Long id, PersonDto payload) throws Exception {
       try {
           var person = this.personService.personConverter(payload);
           this.personService.updatePersonById(id, person);
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
       } catch (TransactionRequiredException e) {
           e.printStackTrace();
           return new ResponseEntity<>(MessageResponse.getErroMessage(), HttpStatus.NOT_FOUND);
       }

    }


}
