package gerenciamento.tarefas.backend.service;

import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.enums.DepartmentsEnum;
import gerenciamento.tarefas.backend.model.response.MessageResponse;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl {

    final PersonRespository personRespository;

    public Person personConverter(PersonDto personDto){
        return Person.builder()
                .name(personDto.getName())
                .document(personDto.getDocument())
                .departments(DepartmentsEnum.departments(personDto.getDepartment().toLowerCase(Locale.ROOT)))
                .build();
    }

    private Boolean verifyUser(String document){
        var responseDocument = personRespository.findByDocument(document);
        return responseDocument.isEmpty() ? true : false;
    }

    public Person savePerson(Person person) throws Exception {

        if(this.verifyUser(person.getDocument())) {
            return personRespository.save(person);
        }else{
            throw new Exception("Document conflit");
        }

    }

    public Optional<Person> findPersonById(Long id) throws Exception {
        return Optional.ofNullable(personRespository.findById(id).orElseThrow(() -> new Exception("Client not found")));

    }

    public PersonDto personConverter(Person person){
        return PersonDto.builder()
                .name(person.getName())
                .document(person.getDocument())
                .department(DepartmentsEnum.departments(person.getDepartments()))
                .build();
    }


    public MessageResponse deletePersonById(Long id) throws Exception {
        var findPerson = personRespository.findById(id);
        if(findPerson.isPresent()){
            this.personRespository.deleteById(id);
        }else{
            throw new Exception("Id not exists");
        }
        return null;
    }


    @Transactional
    public void updatePersonById(Long id, Person payload) {
        var person = personRespository.findById(id);
        if(person.isPresent()){
            this.personRespository.updatePerson(id, payload.getName(), payload.getDocument());
        }else{
            throw new TransactionRequiredException("Id not exists");
        }
    }


}
