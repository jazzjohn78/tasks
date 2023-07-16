package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");
        TaskMapper taskMapper = new TaskMapper();
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1, task.getId());
        assertEquals("test title", task.getTitle());
        assertEquals("test content", task.getContent());
    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test title", "test content");
        TaskMapper taskMapper = new TaskMapper();
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1, taskDto.getId());
        assertEquals("test title", taskDto.getTitle());
        assertEquals("test content", taskDto.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = List.of(new Task(1L, "test title", "test content"));
        TaskMapper taskMapper = new TaskMapper();
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(1, taskDtoList.size());
        assertEquals(1, taskDtoList.get(0).getId());
        assertEquals("test title", taskDtoList.get(0).getTitle());
        assertEquals("test content", taskDtoList.get(0).getContent());
    }

}