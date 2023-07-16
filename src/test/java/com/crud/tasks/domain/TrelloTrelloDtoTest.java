package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloTrelloDtoTest {

    @Test
    void testTrelloTrelloDtoSettersAndGetters() {
        //Given
        TrelloTrelloDto trelloTrelloDto = new TrelloTrelloDto();
        //When
        trelloTrelloDto.setBoard(1);
        trelloTrelloDto.setCard(2);
        int board = trelloTrelloDto.getBoard();
        int card = trelloTrelloDto.getCard();
        //Then
        assertEquals(1, board);
        assertEquals(2, card);
    }

}