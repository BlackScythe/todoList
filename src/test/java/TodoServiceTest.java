import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import io.finalprj.todolist.entity.TodoItem;
import io.finalprj.todolist.repository.TodoRepository;
import io.finalprj.todolist.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TodoServiceTest {
    private TodoService todoService = null;
    private TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
    private Iterable<TodoItem> todosIterable = Arrays.asList(new TodoItem("todo1", true), new TodoItem("todo2", false), new TodoItem("todo3", false));

    @Before
    public void setUp() {
        todoService = new TodoService(todoRepository);
    }

    @Test
    public void getTodosTest() {
        when(todoRepository.findAll()).thenReturn(this.todosIterable);
        List<TodoItem> todosList = StreamSupport
                .stream(todoService.getTodos().spliterator(), false)
                .collect(Collectors.toList());
        assertTrue(todosList.size() > 0);
        assertTrue(todoService.getTodos() instanceof Iterable);
        todosList = todosList.stream()
                .filter(t -> t instanceof TodoItem)
                .collect(Collectors.toList());
        assertEquals(3, todosList.size());
    }

    @Test
    public void getTodoTestTrue() {
        when(todoRepository.findByStatus(true)).thenReturn(
                StreamSupport.stream(this.todosIterable.spliterator(), false)
                        .filter(t -> t.getStatus() == true)
                        .collect(Collectors.toList())
        );
        List<TodoItem> todosList = StreamSupport
                .stream(todoService.getStatusTodos(true).spliterator(), false)
                .collect(Collectors.toList());
        assertTrue(todosList.size() > 0);
        assertEquals(1, todosList.size());
        assertEquals("todo1", todosList.get(0).getTodo());
    }

    @Test
    public void getTodoTestFalse() {
        when(todoRepository.findByStatus(false)).thenReturn(
                StreamSupport.stream(this.todosIterable.spliterator(), false)
                        .filter(t -> t.getStatus() == false)
                        .collect(Collectors.toList())
        );
        List<TodoItem> todosList = StreamSupport
                .stream(todoService.getStatusTodos(false).spliterator(), false)
                .collect(Collectors.toList());
        assertTrue(todosList.size() > 0);
        assertEquals(2, todosList.size());
        assertEquals("todo2", todosList.get(0).getTodo());
        assertEquals("todo3", todosList.get(1).getTodo());
    }

    @Test
    public void createTodoTest() {
        TodoItem todo = new TodoItem("todo4", false);
        when(todoRepository.save(todo)).thenReturn(todo);
        assertEquals("todo4", todoService.createTodo(todo).getTodo());
        assertEquals(false, todoService.createTodo(todo).getStatus());
    }
}
