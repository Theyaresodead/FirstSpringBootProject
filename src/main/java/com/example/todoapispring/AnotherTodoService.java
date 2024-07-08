package com.example.todoapispring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("anotherTodo")
public class AnotherTodoService implements TodoService {
    @Override
    public String doSomething() {
        return "from another todo service";
    }
}
