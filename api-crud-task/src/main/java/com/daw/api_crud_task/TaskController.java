package com.daw.api_crud_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 

import java.util.List;
import java.util.Optional;

/*CONTROLLER CLASS: TaskController
  This class handles all HTTP requests directed to the API.
  It acts as the intermediary between the web client and the data layer (Repository).*/
@RestController
     /*1. @RestController: Combines @Controller (marks the class as a web component) 
       and @ResponseBody (indicates methods return direct data, not HTML views).*/
@RequestMapping("/api/tasks")
     /*2. @RequestMapping("/api/tasks"): Defines the base URL for all methods in this class.
       All internal routes will start with: http://localhost:8080/api/tasks*/
public class TaskController {

    // 3. DEPENDENCY INJECTION (IoC)
    @Autowired 
    private TaskRepository taskRepository;
     /*@Autowired tells Spring to find an instance of TaskRepository 
       and automatically inject it here. This allows the Controller to use 
       all the CRUD methods without manual instantiation.*/

    
    // =======================================================
    // R - READ: GET ALL TASKS
    // =======================================================
    @GetMapping 
    // @GetMapping: Maps HTTP GET requests to the base URL (/api/tasks)
    public List<Task> getAllTasks() {
        // Calls the findAll() method inherited from JpaRepository
        return taskRepository.findAll();
    }


    // =======================================================
    // C - CREATE: CREATE NEW TASK
    // =======================================================
    @PostMapping
    // @PostMapping: Maps HTTP POST requests to the base URL (/api/tasks)
    @ResponseStatus(HttpStatus.CREATED) // Optional: Returns HTTP code 201 (Created)
    public Task createTask(@RequestBody Task newTask) {
        /*@RequestBody: Spring takes the JSON from the request body and 
          automatically converts it into a Task object (thanks to Jackson and Lombok).*/
        return taskRepository.save(newTask); // Saves the object to the DB
    }
    
    
    // =======================================================
    // R - READ: GET BY ID
    // =======================================================
    @GetMapping("/{id}")
    // @GetMapping("/{id}"): Maps GET to a URL with a dynamic parameter (e.g., /api/tasks/1)
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        // @PathVariable Long id: Captures the ID value from the URL.
        
        // findById() returns an Optional<Task> to handle if the object doesn't exist
        Optional<Task> task = taskRepository.findById(id); 
        
        /*Use of Optional: If the task is found (.map), it returns 200 OK and the task.
          If it's not found (.orElseGet), it returns 404 Not Found.*/
        return task.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // =======================================================
    // U - UPDATE: UPDATE EXISTING TASK
    // =======================================================
    @PutMapping("/{id}")
    // @PutMapping: Maps HTTP PUT requests to update an existing resource.
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        
        return taskRepository.findById(id)
            .map(existingTask -> {
                // 1. Update the fields of the existing task with the new details
                existingTask.setTitulo(taskDetails.getTitulo());
                existingTask.setDescripcion(taskDetails.getDescripcion());
                existingTask.setCompletada(taskDetails.isCompletada()); 

                // 2. Calls save(). If the object has an existing ID, JPA updates instead of inserting.
                Task updatedTask = taskRepository.save(existingTask);
                return ResponseEntity.ok(updatedTask); // Returns 200 OK
            })
            .orElseGet(() -> ResponseEntity.notFound().build()); 
    }


    // =======================================================
    // D - DELETE: DELETE TASK
    // =======================================================
    @DeleteMapping("/{id}")
    // @DeleteMapping: Maps HTTP DELETE requests to delete a resource.
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            /*ResponseEntity.noContent().build(): Returns 204 No Content, the standard 
              code for a successful deletion without returning a body.*/
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); // Returns 404 if the task doesn't exist
        }
    }
}