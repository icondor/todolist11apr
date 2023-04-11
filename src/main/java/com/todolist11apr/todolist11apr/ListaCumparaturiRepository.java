package com.todolist11apr.todolist11apr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaCumparaturiRepository extends JpaRepository<ListaCumparaturiModel, Long> {
}
