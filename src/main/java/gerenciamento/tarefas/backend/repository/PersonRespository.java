package gerenciamento.tarefas.backend.repository;

import gerenciamento.tarefas.backend.model.Person;
import gerenciamento.tarefas.backend.model.Task;
import gerenciamento.tarefas.backend.model.response.PersonTaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRespository extends JpaRepository<Person, Long> {

    Optional<String> findByDocument(String document);

    @Modifying
    @Query(nativeQuery = true, value = "update Person set name = :name, document = :document WHERE id = :id")
    void updatePerson(@Param("id") Long id, @Param("name") String name, @Param("document") String document);

    Optional<Person> findFirstByDocument(String document);








}
