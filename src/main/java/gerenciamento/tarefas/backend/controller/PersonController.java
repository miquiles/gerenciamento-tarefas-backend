package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/")
public interface PersonController{

    @PostMapping("/save-person")
    public ResponseEntity<?> save(@RequestBody PersonDto payload);

    @GetMapping("/fetch/{id}")
    public ResponseEntity findPerson(@PathVariable("id") Long id) throws Exception;

    @DeleteMapping("/delete/person/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id);

    @PutMapping("/put/person/{id}")
    public ResponseEntity updatePerson(@PathVariable("id") Long id, @RequestBody PersonDto payload) throws Exception;


}
