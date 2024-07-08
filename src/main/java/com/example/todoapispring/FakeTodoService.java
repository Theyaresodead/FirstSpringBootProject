package com.example.todoapispring;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("fakeTodo")
public class FakeTodoService implements TodoService {

    @TimeMonitor
    public String doSomething(){
       return ("Doing Something");
    }
}
