package com.daw.api_crud_task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*REPOSITORY INTERFACE: TaskRepository
  This interface represents the Data Access Layer (DAL).
  Its job is to communicate our application with the database (H2, in this case).*/
@Repository
    /*1. @Repository: Spring annotation that marks this interface as a 
      Spring 'bean' responsible for data management. Spring knows it must
      create a concrete implementation at runtime.*/
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    /*2. JpaRepository<T, ID>: This is where the "Spring Data magic" happens.
      By extending JpaRepository, our interface automatically inherits
      OVER 12 BASIC CRUD METHODS, such as:
      - save(Task entity): Saves or updates a task.
      - findAll(): Returns all tasks.
      - findById(Long id): Finds a task by its ID.
      - deleteById(Long id): Deletes a task by its ID.
      The JpaRepository parameters are:
      - Task: The Entity (Model) it will work with.
      - Long: The data type of the Primary Key (the 'id' from Tarea.java).
      
      3. No implementation code here:
      Our interface is empty because Spring, thanks to JpaRepository, 
      automatically generates the concrete class that implements these 
      CRUD methods. We don't need to write a single line of SQL!
      
      
      NOTE: If we wanted a custom search, we would define 
      it here using a specific naming pattern, e.g.:
      List<Task> findByCompleted(boolean completed); 
      Spring Data would automatically know how to write the SQL for that.*/
}