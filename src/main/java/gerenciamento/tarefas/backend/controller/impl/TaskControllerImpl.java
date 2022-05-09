package gerenciamento.tarefas.backend.controller.impl;

import gerenciamento.tarefas.backend.controller.TaskController;
import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import gerenciamento.tarefas.backend.model.response.MessageResponse;
import gerenciamento.tarefas.backend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @Override
    public ResponseEntity saveTask(TaskDto taskDto) throws Exception {
      try {
          var task = taskService.buildTask(taskDto);
          this.taskService.saveTask(task);
          return new ResponseEntity(MessageResponse.getSuccessMessage(), HttpStatus.CREATED);
      }catch (NumberFormatException n) {
          n.printStackTrace();
          return new ResponseEntity<>(MessageResponse.getDepartmentNotFound(), HttpStatus.NOT_FOUND);
      }

    }

    @Override
    public ResponseEntity findTask(Long id) throws Exception {
        var taskResponse = taskService.findById(id);
        return new ResponseEntity(taskResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findAllTasks() {
        var list = taskService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity finishTask(Long id, Task task) {
        this.taskService.finishTask(id);
       return new ResponseEntity(MessageResponse.getSuccessMessage(),HttpStatus.OK);
    }


}
