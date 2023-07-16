package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloBadgesDtoTest {

    @Test
    void testSettersAndGetters() {
        //Given
        TrelloTrelloDto trelloTrelloDto = new TrelloTrelloDto();
        trelloTrelloDto.setBoard(1);
        trelloTrelloDto.setCard(2);
        TrelloAttachmentsDto trelloAttachmentsDto = new TrelloAttachmentsDto();
        trelloAttachmentsDto.setTrello(trelloTrelloDto);
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto();

        //When
        trelloBadgesDto.setVotes(1);
        trelloBadgesDto.setAttachments(trelloAttachmentsDto);
        int votes = trelloBadgesDto.getVotes();
        int board = trelloBadgesDto.getAttachments().getTrello().getBoard();
        int card = trelloBadgesDto.getAttachments().getTrello().getCard();

        //Then
        assertEquals(1, votes);
        assertEquals(1, board);
        assertEquals(2, card);
    }

}