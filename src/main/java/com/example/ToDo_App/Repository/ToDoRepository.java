package com.example.ToDo_App.Repository;

import com.example.ToDo_App.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository  extends JpaRepository<ToDo, Long > {

}
