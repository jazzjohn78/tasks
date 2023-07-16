package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloAttachmentsDtoTest {

    @Test
    void testSetterAndGetter() {
        //Given
        TrelloAttachmentsDto trelloAttachmentsDto = new TrelloAttachmentsDto();
        TrelloTrelloDto trelloTrelloDto = new TrelloTrelloDto();
        trelloTrelloDto.setBoard(1);
        trelloTrelloDto.setCard(2);

        //When
        trelloAttachmentsDto.setTrello(trelloTrelloDto);
        int board = trelloAttachmentsDto.getTrello().getBoard();
        int card = trelloAttachmentsDto.getTrello().getCard();

        //Then
        assertEquals(1, board);
        assertEquals(2, card);
    }

}