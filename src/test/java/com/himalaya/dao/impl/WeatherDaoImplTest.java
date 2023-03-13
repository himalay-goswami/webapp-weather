package com.himalaya.dao.impl;

import com.himalaya.entity.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import static org.mockito.Mockito.*;

class WeatherDaoImplTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private CriteriaBuilderImpl criteriaBuilder;


    @Mock
    private OrderImpl orderBy;

    private WeatherDaoImpl weatherDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherDao = new WeatherDaoImpl(sessionFactory);
    }

    @Test
    void testGetLatestData() {

        Root root = mock(Root.class);
        CriteriaQuery cr = mock(CriteriaQuery.class);
        Query query = mock(Query.class);
        Expression<Weather> idExpression = mock(Expression.class);
        Weather weather = new Weather();

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Weather.class)).thenReturn(cr);
        when(cr.from(Weather.class)).thenReturn(root);
        when(criteriaBuilder.desc(idExpression)).thenReturn(orderBy);
        when(cr.orderBy(orderBy)).thenReturn(cr);
        when(session.createQuery(cr)).thenReturn(query);
        when(query.setMaxResults(1)).thenReturn(query);
        when(query.getSingleResult()).thenReturn(weather);

        WeatherDaoImpl dao = new WeatherDaoImpl(sessionFactory);

        Weather latestData = dao.getLatestData();

        verify(sessionFactory).getCurrentSession();
        verify(session).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Weather.class);
        verify(cr).from(Weather.class);
        verify(root).get("id");

        Assertions.assertEquals(weather, latestData);
    }

    @Test
    void testSave() {
        Weather weather = new Weather();
        weather.setId(1);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        weatherDao.save(weather);
        verify(sessionFactory).getCurrentSession();
        verify(session).saveOrUpdate(weather);
    }


}