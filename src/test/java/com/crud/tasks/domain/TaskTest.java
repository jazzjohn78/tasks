package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskGetters() {
        //Given
        Task task = new Task(1L, "test title", "test content");
        //When
        Long id = task.getId();
        String title = task.getTitle();
        String content = task.getContent();
        //Then
        assertEquals(1, id);
        assertEquals("test title", title);
        assertEquals("test content", content);
    }

}