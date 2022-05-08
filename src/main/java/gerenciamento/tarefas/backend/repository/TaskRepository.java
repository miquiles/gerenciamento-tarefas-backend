package gerenciamento.tarefas.backend.repository;

import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.Task;

import gerenciamento.tarefas.backend.model.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Person> findByPerson(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "update Task set status = :status WHERE id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") int status);



}
