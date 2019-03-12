package com.spring.boot.starter.springbootstarter.app.web.service;

import com.spring.boot.starter.springbootstarter.app.web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public User find(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public User saveOrUpdate(User user) {
        if (user.getId() == 0) {
            em.persist(user);
        } else {
            user = em.merge(user);
        }
        return user;
    }
}
