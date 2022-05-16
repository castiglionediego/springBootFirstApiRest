package com.exampleSpringBoot.springBootFirstApiRest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    Todo emptyTodo1;
    Todo emptyTodo2;
    private Todo todo1;
    private Todo todo2;

    @BeforeEach
    void setUp() {
        emptyTodo1 = new Todo();
        emptyTodo2 = new Todo();

        todo1 = new Todo();
        todo1.setId(1L);
        todo1.setName("MyTodo");
        todo1.setActiveFlag(true);
        todo1.setAssignee("ME");
        todo1.setDue("Today");
        todo1.setNotes("Some notes");

        todo2 = new Todo();
        todo2.setId(1L);
        todo2.setName("MyTodo");
        todo2.setActiveFlag(true);
        todo2.setAssignee("ME");
        todo2.setDue("Today");
        todo2.setNotes("Some notes");

    }

    @Test
    void testEmptyEquals() {
        assertTrue(emptyTodo1.equals(emptyTodo2));
    }

    @Test
    void testContentEquals() {
        assertTrue(todo1.equals(todo2));
    }

    @Test
    void testEmptyHashCode() {
        assertEquals(emptyTodo1.hashCode(), emptyTodo2.hashCode());
    }

    @Test
    void testHashCode() {
        assertNotEquals(emptyTodo1.hashCode(), todo2.hashCode());
    }

    @Test
    void testEmptyToString() {
        assertEquals(emptyTodo1.toString(), emptyTodo2.toString());
    }

    @Test
    void testContentToString() {
        assertEquals(todo1.toString(), todo2.toString());
    }

    @Test
    void testNotToString() {
        assertNotEquals(emptyTodo1.toString(), todo2.toString());
    }
}