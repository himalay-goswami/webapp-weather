package com.himalaya.dao.impl;

import com.himalaya.dao.WeatherDao;
import com.himalaya.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Slf4j
@Repository
@Transactional
@EnableTransactionManagement
public class WeatherDaoImpl implements WeatherDao {

    private final SessionFactory sessionFactory;

    public WeatherDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Weather getLatestData() {

        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Weather>  cr = cb.createQuery(Weather.class);

        Root<Weather> root = cr.from(Weather.class);
        cr.orderBy(cb.desc(root.get("id")));

        Query<Weather> query = currentSession.createQuery(cr);
        query.setMaxResults(1);

        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }

    @Override
    public void save(Weather weather) {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(weather);
    }
}
