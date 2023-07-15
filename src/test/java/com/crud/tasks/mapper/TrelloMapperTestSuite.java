package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloMapperTestSuite {

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("id 1", "name 1", false);
        List<TrelloListDto> dtoList = new ArrayList<>();
        dtoList.add(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("board id 1", "board name 1", dtoList);
        List<TrelloBoardDto> boardDtoList = new ArrayList<>();
        boardDtoList.add(trelloBoardDto);
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(boardDtoList);
        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("board id 1", trelloBoards.get(0).getId());
        assertEquals("board name 1", trelloBoards.get(0).getName());
        assertEquals(1, trelloBoards.get(0).getLists().size());
        assertEquals("id 1", trelloBoards.get(0).getLists().get(0).getId());
        assertEquals("name 1", trelloBoards.get(0).getLists().get(0).getName());
        assertFalse(trelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList("id 1", "name 1", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("board id 1", "board name 1", list);
        List<TrelloBoard> boardList = new ArrayList<>();
        boardList.add(trelloBoard);
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(boardList);
        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals("board id 1", trelloBoardDtos.get(0).getId());
        assertEquals("board name 1", trelloBoardDtos.get(0).getName());
        assertEquals(1, trelloBoardDtos.get(0).getLists().size());
        assertEquals("id 1", trelloBoardDtos.get(0).getLists().get(0).getId());
        assertEquals("name 1", trelloBoardDtos.get(0).getLists().get(0).getName());
        assertFalse(trelloBoardDtos.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("id 1", "name 1", false);
        List<TrelloListDto> dtoList = new ArrayList<>();
        dtoList.add(trelloListDto);
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(dtoList);
        //Then
        assertEquals(1, trelloList.size());
        assertEquals("id 1", trelloList.get(0).getId());
        assertEquals("name 1", trelloList.get(0).getName());
        assertFalse(trelloList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("id 1", "name 1", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList);
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        List<TrelloListDto> dtoList = trelloMapper.mapToListDto(list);
        //Then
        assertEquals(1, dtoList.size());
        assertEquals("id 1", dtoList.get(0).getId());
        assertEquals("name 1", dtoList.get(0).getName());
        assertFalse(dtoList.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card 1", "description 1", "pos 1", "list 1");
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("card 1", trelloCardDto.getName());
        assertEquals("description 1", trelloCardDto.getDescription());
        assertEquals("pos 1", trelloCardDto.getPos());
        assertEquals("list 1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card 1", "description 1", "pos 1", "list 1");
        TrelloMapper trelloMapper = new TrelloMapper();
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("card 1", trelloCard.getName());
        assertEquals("description 1", trelloCard.getDescription());
        assertEquals("pos 1", trelloCard.getPos());
        assertEquals("list 1", trelloCard.getListId());
    }
}
