package gerenciamento.tarefas.backend.controller.impl;

import gerenciamento.tarefas.backend.controller.PersonController;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.response.MessageResponse;
import gerenciamento.tarefas.backend.service.PersonServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PersonControllerImpl implements PersonController {

    final PersonServiceImpl personServiceImpl;

    @Override
    public ResponseEntity<?> savePerson(PersonDto payload) {
        try {
            var person = personServiceImpl.personConverter(payload);
            this.personServiceImpl.savePerson(person);
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
            var person = personServiceImpl.findPersonById(id);
            var personResponse = personServiceImpl.personConverter(person.get());
            return new ResponseEntity<>(personResponse,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(MessageResponse.getPersonNotFoundMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> deletePerson(Long id) {
        try {
            this.personServiceImpl.deletePersonById(id);
            return new ResponseEntity<>(MessageResponse.getSuccessDeleteMessage(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(MessageResponse.getErroMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public ResponseEntity updatePerson(Long id, PersonDto payload) {
       try {
           var person = this.personServiceImpl.personConverter(payload);
           this.personServiceImpl.updatePersonById(id, person);
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(MessageResponse.getErroMessage(), HttpStatus.NOT_FOUND);
       }

    }


}
