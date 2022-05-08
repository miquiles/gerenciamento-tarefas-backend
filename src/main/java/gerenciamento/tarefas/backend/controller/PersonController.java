package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person/")
public interface PersonController{

    @PostMapping("/save-person")
    public ResponseEntity<?> savePerson(@RequestBody PersonDto payload);

    @GetMapping("/fetch/{id}")
    public ResponseEntity findPerson(@PathVariable("id") Long id) throws Exception;

    @DeleteMapping("/delete/person/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id);

    @PutMapping("/put/person/{id}")
    public ResponseEntity updatePerson(@PathVariable("id") Long id, @RequestBody PersonDto payload);

//    @PutMapping("/tasks/edit/{id}")
//    public ResponseEntity personToTask(@RequestBody PersonDto payload, @PathVariable("id") Long id) throws Exception;


}
