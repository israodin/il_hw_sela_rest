package il.hw.sela.rest.controller;

import il.hw.sela.rest.model.GreetingCard;
import il.hw.sela.rest.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by israo on 6/24/2017.
 */

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;


    @RequestMapping(value = "/save", method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void create (@RequestBody GreetingCard greetingCard ){
        cardService.save(greetingCard);
    }

//    @RequestMapping(value = "/update",method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public void update(@RequestBody GreetingCard  greetingCard){
//        cardService.update(greetingCard);
//    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public GreetingCard getCardById(@PathVariable("id") Integer cardId) {
        GreetingCard greetingCard = new GreetingCard();
        greetingCard.setCardId(1);
        greetingCard.setContent("This is my first greeting card");
        return cardService.findByCardID(cardId);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GreetingCard> getCards(){
        return cardService.findAll();
    }
}
