package gerenciamento.tarefas.backend.service;
import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import gerenciamento.tarefas.backend.model.enums.DepartmentsEnum;
import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import gerenciamento.tarefas.backend.model.response.PersonTaskResponse;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.repository.TaskRepository;
import gerenciamento.tarefas.backend.util.DateUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    final TaskRepository taskRepository;
    final PersonRespository personRespository;

    public Task saveTask (Task task){
       return taskRepository.save(task);
    }

    public Task findById(Long id) throws Exception {
        return this.taskRepository.findById(id).orElseThrow(() -> new Exception("Id not Found"));
    }


    public Task buildTask (TaskDto taskDto) throws Exception {
        var person = personRespository.findFirstByDocument(taskDto.getPersonDocument());
        if(person.isPresent()){
            return Task.builder()
                    .description(taskDto.getDescription())
                    .deadline(DateUtil.formateDate(taskDto.getDeadline()))
                    .status(TaskStatus.OPEN)
                    .title(taskDto.getTitle())
                    .person(person.get())
                    .startTask(Calendar.getInstance())
                    .departments(DepartmentsEnum.departments(taskDto.getDepartment().toLowerCase(Locale.ROOT)))
                    .duration(DateUtil.duration(DateUtil.formateDate(taskDto.getDeadline())))
                    .build();
        }else {
            return Task.builder()
                .description(taskDto.getDescription())
                .deadline(DateUtil.formateDate(taskDto.getDeadline()))
                .status(TaskStatus.OPEN)
                .title(taskDto.getTitle())
                .startTask(Calendar.getInstance())
                .duration(DateUtil.duration(DateUtil.formateDate(taskDto.getDeadline())))
                .departments(DepartmentsEnum.departments(taskDto.getDepartment().toLowerCase(Locale.ROOT)))
                .build();}
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Transactional
    public void finishTask(Long id){
        this.taskRepository.updateStatus(id, 1);

    }






}
