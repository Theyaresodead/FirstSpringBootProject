package com.example.todoapispring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private static List<Todo> todosList;


    private TodoService todoService1;
    private TodoService todoService2;


    public TodoController(@Qualifier("anotherTodo") TodoService todoService1,
                          @Qualifier("fakeTodo") TodoService todoService2) {
        this.todoService1 =todoService1;
        this.todoService2 =todoService2;
        todosList =new ArrayList<>();
        todosList.add(new Todo(false,1,"Todo 1",1));
        todosList.add(new Todo(true,2,"Todo 2",2));
    }

    @GetMapping("/")
    public List<Todo> getTodo(@RequestParam(required = false) Boolean isCompleted){
       System.out.println("incoming params "+ isCompleted+" "+this.todoService2.doSomething());
       return todosList;
    }

    @PostMapping("/")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newtodo){
        // @ResponseStatus(HttpStatus.CREATED) to get the status code.
        todosList.add(newtodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newtodo);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable long todoId){
        for(Todo todo: todosList){
            if(todo.getId() == todoId){
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable long todoId){
        for(Todo todo: todosList){
            if(todo.getId() == todoId){
                todosList.remove(todo);
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }



}
