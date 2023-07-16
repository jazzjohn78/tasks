package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloValidatorTest {

    @Test
    void testValidateTrelloBoardsRemoveTestBoard() {
        //Given
        List<TrelloBoard> trelloBoards = List.of(
                new TrelloBoard("id 1", "name 1", new ArrayList<>()),
                new TrelloBoard("id 2", "test", new ArrayList<>()));

        TrelloValidator trelloValidator = new TrelloValidator();

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, filteredBoards.size());
    }

}