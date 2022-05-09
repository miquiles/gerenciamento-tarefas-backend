package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/tasks")
public interface TaskController {

    @PostMapping("/register")
    public ResponseEntity saveTask(@RequestBody @Valid TaskDto taskDto)throws Exception;

    @GetMapping("/find/{id}")
    public ResponseEntity findTask(@PathVariable Long id) throws Exception;

    @GetMapping("/find-all")
    public ResponseEntity findAllTasks();

    @PutMapping("/finish/{id}")
    public ResponseEntity finishTask(@PathVariable("id") Long id, @RequestBody Task task);

}
