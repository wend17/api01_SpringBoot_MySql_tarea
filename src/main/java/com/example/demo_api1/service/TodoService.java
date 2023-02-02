package com.example.demo_api1.service;

import com.example.demo_api1.Model.Task;
import com.example.demo_api1.Repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Task> findAll() {
        return todoRepository.findAll();
    }

    public Task save(Task task) {
        return todoRepository.save(task);
    }

    public Task updateTask (Long id , Task task){
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        return todoRepository.save(updatedTask);
    }

    public void deleteTask (Long id) {
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);

    }
}
