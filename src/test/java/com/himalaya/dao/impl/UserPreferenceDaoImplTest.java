package com.himalaya.dao.impl;

import com.himalaya.entity.UserPref;
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

class UserPreferenceDaoImplTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private CriteriaBuilderImpl criteriaBuilder;

    @Mock
    private OrderImpl orderBy;

    private UserPreferenceDaoImpl userPreferenceDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userPreferenceDao = new UserPreferenceDaoImpl(sessionFactory);
    }


    @Test
    void testUserPreferenceData() {

        Root root = mock(Root.class);
        CriteriaQuery cr = mock(CriteriaQuery.class);
        Query query = mock(Query.class);
        Expression<UserPref> idExpression = mock(Expression.class);
        UserPref userPref = new UserPref();

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(UserPref.class)).thenReturn(cr);
        when(cr.from(UserPref.class)).thenReturn(root);
        when(criteriaBuilder.desc(idExpression)).thenReturn(orderBy);
        when(cr.orderBy(orderBy)).thenReturn(cr);
        when(session.createQuery(cr)).thenReturn(query);
        when(query.setMaxResults(1)).thenReturn(query);
        when(query.getSingleResult()).thenReturn(userPref);

        UserPreferenceDaoImpl dao = new UserPreferenceDaoImpl(sessionFactory);

        UserPref userPrefDao = dao.getPreferences();

        verify(sessionFactory).getCurrentSession();
        verify(session).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(UserPref.class);
        verify(cr).from(UserPref.class);
        verify(root).get("id");

        Assertions.assertEquals(userPref, userPrefDao);
    }


    @Test
    public void testSave(){
        UserPref userPref = new UserPref();
        userPref.setMinValue(15);
        userPref.setMaxValue(25);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        userPreferenceDao.saveUserPreference(userPref);
        verify(sessionFactory).getCurrentSession();
        verify(session).saveOrUpdate(userPref);
    }

























}