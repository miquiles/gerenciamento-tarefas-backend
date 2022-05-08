package gerenciamento.tarefas.backend.repository;

import gerenciamento.tarefas.backend.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
