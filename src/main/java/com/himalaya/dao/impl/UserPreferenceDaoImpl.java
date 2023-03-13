package com.himalaya.dao.impl;

import com.himalaya.dao.UserPreferenceDao;
import com.himalaya.entity.UserPref;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional
@EnableTransactionManagement
public class UserPreferenceDaoImpl implements UserPreferenceDao {

    //dao class for user preference entity

    private final SessionFactory sessionFactory;

    public UserPreferenceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUserPreference(UserPref userPreference) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userPreference);
    }

    @Override
    public UserPref getPreferences() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserPref> cr = cb.createQuery(UserPref.class);

        Root<UserPref> root = cr.from(UserPref.class);
        cr.orderBy(cb.desc(root.get("id")));

        Query<UserPref> query = session.createQuery(cr);
        query.setMaxResults(1);

        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }
}
