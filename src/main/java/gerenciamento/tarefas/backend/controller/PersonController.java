package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/person/")
public interface PersonController{

    @PostMapping("/register")
    public ResponseEntity<?> savePerson(@RequestBody @Valid PersonDto payload);

    @GetMapping("/fetch/{id}")
    public ResponseEntity findPerson(@PathVariable("id") Long id) throws Exception;

    @GetMapping("/find-all")
    public ResponseEntity findAllTasksWithPerson() throws Exception;

    @GetMapping("/list-all")
    public ResponseEntity findAll() throws Exception;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id);

    @PutMapping("/edit/{id}")
    public ResponseEntity updatePerson(@PathVariable("id") Long id, @RequestBody PersonDto payload);

    @PutMapping("/person-to-task/{id}")
    public ResponseEntity personInTask(@RequestBody @Valid PersonDto payload, @PathVariable("id") Long id) throws Exception;





}
