package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
            System.out.println("This board contains lists:");
            trelloBoardDto.getLists().forEach(trelloList -> {
                System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
            });
        });

        /*trelloBoards.stream()
                .filter(b -> b.getName() != null)
                .filter(b -> b.getId() != null)
                .filter(b -> b.getName().contains("Kodilla"))
                .map(b -> b.getId() + " " + b.getName())
                .forEach(System.out::println);*/
    }

    @PostMapping("cards")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        CreatedTrelloCard card = trelloClient.createNewCard(trelloCardDto);

        System.out.println("Created card: " + card.getId() + " - " + card.getName() + " - " + card.getShortUrl());
        System.out.println("Card has badges votes quantity: " + card.getBadges().getVotes());
        System.out.println("Card's attachmentByType has Trello with board equal to: " + card.getBadges().getAttachments().getTrello().getBoard() +
                " and card equal to: " + card.getBadges().getAttachments().getTrello().getCard());

        return card;
    }
}
