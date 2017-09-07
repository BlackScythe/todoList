import io.finalprj.todolist.controller.TodoController;
import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TodoTest {

    private TodoController todoController = null;
    private TodoService todoService = Mockito.mock(TodoService.class);

    @Before
    public void setUp(){
        todoController = new TodoController(todoService);
    }

    @Test
    public void getTodosMock(){
        Iterable<TodoItem> todos = Arrays.asList(new TodoItem("todo1",false), new TodoItem("todo2",false), new TodoItem("todo3",false));
        when(todoService.getTodos()).thenReturn(todos);
        Optional<Long> i = Optional.empty();
        Optional<Boolean> b = Optional.empty();
        Optional<String> s = Optional.empty();
        assertTrue(todoController.getTodos(i,b,s) instanceof Iterable);
    }

    @Test
    public void getTodoByIDMock() {
        when(todoService.getTodos()).thenReturn(Arrays.asList(new TodoItem("todo1",false)));
        Optional<Long> i = Optional.of(new Long(1));
        Optional<Boolean> b = Optional.empty();
        Optional<String> s = Optional.empty();
        assertTrue(todoController.getTodos(i,b,s) instanceof Iterable);

    }
}
