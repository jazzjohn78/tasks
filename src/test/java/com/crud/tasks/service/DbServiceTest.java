package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository repository;

    @Test
    void shouldFetchTasks() {
        //Given
        List<Task> taskList = List.of(new Task(1l, "task title", "task content"));
        when(repository.findAll()).thenReturn(taskList);
        //When
        List<Task> resultList = dbService.getAllTasks();
        //Then
        assertEquals(1, resultList.size());
        assertEquals(1, resultList.get(0).getId());
        assertEquals("task title", resultList.get(0).getTitle());
        assertEquals("task content", resultList.get(0).getContent());
    }

    @Test
    void shouldSaveTask() {
        //Given
        Task task = new Task(1l, "task title", "task content");
        when(repository.save(any(Task.class))).thenReturn(task);
        //When
        Task resultTask = dbService.saveTask(task);
        //Then
        assertEquals(1, resultTask.getId());
        assertEquals("task title", resultTask.getTitle());
        assertEquals("task content", resultTask.getContent());
    }

}