package il.hw.sela.rest.model;

import javax.persistence.*;

/**
 * Created by israo on 6/24/2017.
 */
@Entity
@Table(name = "GREETING_CARD")
public class GreetingCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardId;

    @Column(name = "CONTENT",nullable = false,length = 1000)
    private String content;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
