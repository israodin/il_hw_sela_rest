package il.hw.sela.rest.repo;

import il.hw.sela.rest.model.GreetingCard;

import java.util.List;

/**
 * Created by israo on 6/24/2017.
 */
public interface CardRepository {

    void save (GreetingCard greetingCard);
    void update (GreetingCard greetingCard);
    GreetingCard findByCardID(Integer cardID);
    List<GreetingCard> findAll();

}
