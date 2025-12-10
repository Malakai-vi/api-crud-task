package com.daw.api_crud_task;

// Essential Jakarta Persistence API (JPA) Imports
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Lombok Import
import lombok.Data; 

/*MODEL / ENTITY CLASS: Task
  This class represents the 'Task' table in the database.
  It defines the structure of the data we will store.*/
@Entity
/*@Entity is the most important annotation: it tells Hibernate (the JPA engine) 
  to create a table in the database (DB) with the same name as this class.*/
 
@Data
/*@Data (from Lombok): This annotation is very useful in Entities.
  It automatically generates all the 'boilerplate' (repetitive) code:
  - Getters and Setters for all fields.
  - Constructors.
  - toString(), hashCode(), and equals() methods.*/
public class Task {

    // ----------------------------------------------------
    // Entity Attributes (Table Columns)
    // ----------------------------------------------------

    @Id // 1. Marks this field as the PRIMARY KEY of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
         /*2. Defines how the 'id' value is generated. 
           IDENTITY tells the DB to handle auto-generation (auto-increment), 
           ensuring every new Task has a unique ID.*/
    private Long id; 

    // Regular fields (automatically converted into table columns)
    private String title;       // 'title' column (VARCHAR type)
    private String description; // 'description' column (VARCHAR type)
    private boolean completed;  // 'completed' column (BOOLEAN type)

    // Note: Thanks to @Data, we don't have to write the Getter/Setter methods
}