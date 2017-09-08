import io.finalprj.todolist.controller.TodoController;
import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TodoControllerTest {

    private TodoController todoController = null;
    private TodoService todoService = Mockito.mock(TodoService.class);
    private Iterable<TodoItem> todosIterable = Arrays.asList(new TodoItem("todo1", true), new TodoItem("todo2", false), new TodoItem("todo3", false));


    @Before
    public void setUp() {
        todoController = new TodoController(todoService);
    }

    @Test
    public void getTodosMock() {
        when(todoService.getTodos()).thenReturn(this.todosIterable);
        Optional<Long> i = Optional.empty();
        Optional<Boolean> b = Optional.empty();
        Optional<String> s = Optional.empty();
        List<TodoItem> todoList = StreamSupport
                .stream(todoController.getTodos(i, b, s).spliterator(), false)
                .collect(Collectors.toList());
        assertTrue(todoController.getTodos(i, b, s) instanceof Iterable);
        assertEquals(3, todoList.size());
    }

    @Test
    public void getTodoByIDMock() {
        when(todoService.getTodos()).thenReturn(Arrays.asList(new TodoItem("todo1", false)));
        Optional<Long> i = Optional.of(new Long(1));
        Optional<Boolean> b = Optional.empty();
        Optional<String> s = Optional.empty();
        assertTrue(todoController.getTodos(i, b, s) instanceof Iterable);

    }
}
