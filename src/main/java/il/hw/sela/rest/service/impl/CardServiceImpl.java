package il.hw.sela.rest.service.impl;

import il.hw.sela.rest.model.GreetingCard;
import il.hw.sela.rest.repo.CardRepository;
import il.hw.sela.rest.service.CardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by israo on 6/24/2017.
 */
@Service
@Transactional
public class CardServiceImpl  implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    @Transactional
    public void save(GreetingCard greetingCard) {
        Map map = getValidationErrors(greetingCard,false);
        if(!map.isEmpty()){
            throw new RuntimeException(map.toString());
        }
        cardRepository.save(greetingCard);
    }


    @Override
    @Transactional
    public void update(GreetingCard greetingCard) {
        Map map = getValidationErrors(greetingCard,true);
        if(!map.isEmpty()){
            throw new RuntimeException(map.toString());
        }
        cardRepository.update(greetingCard);
    }

    @Override
    @Transactional
    public GreetingCard findByCardID(Integer cardID) {
        Map<String,String> cardIDVAlidationErrors = getCardIDValidationErrors(cardID);
        if(!cardIDVAlidationErrors.isEmpty()){
            throw new  RuntimeException(cardIDVAlidationErrors.toString());
        }
        return cardRepository.findByCardID(cardID);
    }

    @Override
    public List<GreetingCard> findAll() {
        return cardRepository.findAll();
    }


    private Map<String,String> getValidationErrors(GreetingCard greetingCard, boolean isCardIdrequired) {
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(greetingCard.getContent())){
            map.put("content","null");
        }
        if(greetingCard.getContent().length()>1000){
            map.put("content","Length >1000");
        }
        if(isCardIdrequired){
            Map<String,String> cardIDValidationErrors = getCardIDValidationErrors(greetingCard.getCardId());
            if(!cardIDValidationErrors.isEmpty()){
                map.putAll(cardIDValidationErrors);
            }
        }
        return map;
    }
    private Map<String,String> getCardIDValidationErrors(Integer cardID) {
        Map<String,String> map = new HashMap<>();
        if(cardID==null){
            map.put("cardID","Null");
            return map;
        }else if(cardID<=0){
            map.put("cardId","Zero or  negative  CardId");
            return map;
        }else if(cardID>Integer.MAX_VALUE){
            map.put("cardId","Too big CardId value");
            return map;
        }
        return map;
    }

}
