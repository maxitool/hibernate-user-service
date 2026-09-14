package org.example.hibernate.dao;

import org.example.hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class AbstractDaoImplementTest extends AbstractIntegrationTest {

    @Test
    void when_initAbstractDaoWithNullEntityClass_then_throwInInitializerError() {
        assertThrows(ExceptionInInitializerError.class,
                this::initAbstractDaoWithNullEntityClass);
    }

    private void initAbstractDaoWithNullEntityClass() {
        BadDao badDao = new BadDao(null, HibernateUtil.getSessionFactory());
    }


    @Test
    @Tag("SkipInitDatabase")
    void when_initAbstractDaoWithNullSessionFactory_then_throwInInitializerError() {
        assertThrows(ExceptionInInitializerError.class,
                this::initAbstractDaoWithNullSessionFactory);
    }

    private void initAbstractDaoWithNullSessionFactory() {
        BadDao badDao = new BadDao(Long.class, null);
    }


    private static class BadDao extends AbstractDaoImplement<Long, Long> {

        protected BadDao(Class<Long> entityClass, SessionFactory sessionFactory) {
            super(entityClass, sessionFactory);
        }
    }
}
