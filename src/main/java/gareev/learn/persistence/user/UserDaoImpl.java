package gareev.learn.persistence.user;

import gareev.learn.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager em;


    @Override
    public Long count() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(User.class)));
        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> q = em.createQuery(
                "select u from User u", User.class
        );
        return q.getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public User createUser(User user) {
        em.persist(user);
        return user;
    }
}
