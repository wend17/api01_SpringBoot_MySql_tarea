package com.example.demo_api1.Controller;

import com.example.demo_api1.Model.Task;

import com.example.demo_api1.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value="/")
    public String holaWendy(){
        return "Hola Oscar !!!";
    }

    @GetMapping(value="/tasks")
    public List<Task>getTasks(){
        return todoService.findAll();
    }

    @PostMapping(value = "/savetasks")
    public Task saveTask(@RequestBody Task task){
        return todoService.save(task);
    }

   @PutMapping(value="/updated/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task){
        return todoService.updateTask(id,task);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteTask(@PathVariable long id){
        todoService.deleteTask(id);
        return "Delete Task";
    }
}
