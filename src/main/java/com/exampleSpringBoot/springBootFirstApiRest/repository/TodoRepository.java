package com.exampleSpringBoot.springBootFirstApiRest.repository;

import com.exampleSpringBoot.springBootFirstApiRest.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByAssignee(String assignee);

    List<Todo> findByActiveFlagTrue();

    List<Todo> findByActiveFlagTrueAndAssignee(String assignee);

    Optional<List<Todo>> findByNotesContaining(String value);

    @Query(value = "SELECT t FROM Todo t WHERE t.notes LIKE %:value% ")
    Optional<List<Todo>> findCustomNotes(@Param("value") String value);
}
