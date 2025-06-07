package com.example.ToDo_App.Service;

import com.example.ToDo_App.Repository.ToDoRepository;
import com.example.ToDo_App.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDoItems(){
        ArrayList<ToDo> todoList = new ArrayList<>();
        toDoRepository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    public ToDo getToDoItemById(Long id){
        return toDoRepository.findById(id).get();  //get yha optional mai se object nikalega
    }

    public boolean updateStatus(Long id){
        ToDo todo = getToDoItemById(id);
        todo.setStatus("completed");
        return saveOrUpdateToDoItem(todo);
    }

    public boolean saveOrUpdateToDoItem(ToDo todo){
        ToDo updatedObj = toDoRepository.save(todo);
        if(getToDoItemById(updatedObj.getId()) != null){
            return true;
        }
        return false;
    }

    public boolean deleteToDoItem(Long id){
        toDoRepository.deleteById(id);
        if(toDoRepository.findById(id).isPresent()){
            return true;
        }
        return false;
    }
}
