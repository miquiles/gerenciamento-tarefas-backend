package gerenciamento.tarefas.backend.service;
import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.dto.TaskDto;
import gerenciamento.tarefas.backend.model.enums.DepartmentsEnum;
import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import gerenciamento.tarefas.backend.repository.PersonRespository;
import gerenciamento.tarefas.backend.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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


    public String deadlineCalcule(Date finalDeadLine){
        var nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        return "";

    }

    public Task buildTask (TaskDto taskDto) throws Exception {
        var person = personRespository.findFirstByDocument(taskDto.getPersonDocument());
        if(person.isPresent()){
            return Task.builder()
                    .description(taskDto.getDescription())
                    .deadline(formatDate(taskDto.getDeadline()))
                    .status(TaskStatus.CLOSED)
                    .title(taskDto.getTitle())
                    .person(person.get())
                    .startTask(Calendar.getInstance())
                    .departments(DepartmentsEnum.departments(taskDto.getDepartment().toLowerCase(Locale.ROOT)))
                    .build();
        }else {
            return Task.builder()
                .description(taskDto.getDescription())
                .deadline(formatDate(taskDto.getDeadline()))
                .status(TaskStatus.CLOSED)
                .title(taskDto.getTitle())
                .startTask(Calendar.getInstance())
                .departments(DepartmentsEnum.departments(taskDto.getDepartment().toLowerCase(Locale.ROOT)))
                .build();}
    }

    public Date formatDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        var dateFormat = format.parse(date);
        return dateFormat;

    }

    public Date duration (String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        var dateFormat = format.parse(date);
        return dateFormat;
    }






}
