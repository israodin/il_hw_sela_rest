package il.hw.sela.rest.repo.impl;

import il.hw.sela.rest.model.GreetingCard;
import il.hw.sela.rest.repo.CardRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * Created by israo on 6/24/2017.
 */

@Repository
public class CardRepositoryImpl implements CardRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void save(GreetingCard greetingCard) {
        getSession().save(greetingCard);
    }

    @Override
    public void update(GreetingCard greetingCard) {
        GreetingCard load = getSession().load(GreetingCard.class,greetingCard.getCardId());
        load.setContent(greetingCard.getContent());
        getSession().update(load);
    }

    @Override
    public GreetingCard findByCardID(Integer cardID) {
        return getSession().get(GreetingCard.class,cardID);
    }

    @Override
    public List<GreetingCard> findAll() {
        StringBuilder hql = new StringBuilder();
        hql.append("From GreetingCard");
        Query query = getSession().createQuery(hql.toString());
        return query.getResultList();
    }
}
