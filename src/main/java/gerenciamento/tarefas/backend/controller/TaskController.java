package gerenciamento.tarefas.backend.controller;

import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.PersonDto;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/tasks")
public interface TaskController {

    @PostMapping("/save")
    public ResponseEntity saveTask(@RequestBody TaskDto taskDto)throws Exception;

    @GetMapping("/find-task/{id}")
    public ResponseEntity findTask(@PathVariable Long id) throws Exception;

    @GetMapping("/find-all")
    public ResponseEntity findAllTasks();

    @PutMapping("/finish/task/{id}")
    public ResponseEntity finishTask(@PathVariable("id") Long id, @RequestBody Task task);

}
