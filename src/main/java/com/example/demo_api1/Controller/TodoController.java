package com.example.demo_api1.Controller;

import com.example.demo_api1.Model.Task;
import com.example.demo_api1.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value="/")
    public String holaWendy(){
        return "Hola Oscar !!!";
    }

    @GetMapping(value="/tasks")
    public List<Task>getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savetasks")
    public Task saveTask(@RequestBody Task task){
        return todoRepository.save(task);
    }

    @PutMapping(value="/updated/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        return todoRepository.save(updatedTask);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "Delete Task";
    }
}
