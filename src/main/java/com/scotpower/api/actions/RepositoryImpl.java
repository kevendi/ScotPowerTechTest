package com.scotpower.api.actions;

import com.scotpower.api.model.Gas;
import com.scotpower.api.model.User;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Singleton
public class RepositoryImpl implements Repository{

    private final EntityManager entityManager;

    public RepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @TransactionalAdvice
    public Optional<User> findUser(Integer account_num) {;
        return Optional.ofNullable(entityManager.find(User.class, account_num));
    }

    @Override
    @ReadOnly
    public List<Object> findReadings(Integer account_num) {
        Optional<User> findUser = findUser(account_num);
        if (findUser.isPresent()) {
            User user = findUser.get();
            if (user.getGas()) {
                Query gasQuery = entityManager.createNativeQuery("SELECT * FROM GAS_READINGS WHERE meter_id =:meter_id", Gas.class);
                Long meterID = user.getMeterID();
                gasQuery.setParameter("meter_id", meterID);
                return gasQuery.getResultList();
            }
        }
        return null;
    }

    @Override
    @TransactionalAdvice
    public void insertUser() {
        entityManager.createNativeQuery("INSERT INTO users (account_number, since, gas, electric, name, meter_id) VALUES (?,?,?,?,?,?)")
                .setParameter(1, 4563)
                .setParameter(2, 20150330)
                .setParameter(3, true)
                .setParameter(4, true)
                .setParameter(5, "Kevin")
                .setParameter(6, 678753)
                .executeUpdate();
    }

    @Override
    @TransactionalAdvice
    public void insertReading() {
        entityManager.createNativeQuery("INSERT INTO GAS_READINGS (id, meter_id, reading, recorded) VALUES (?,?,?,?)")
                .setParameter(1, 453453 )
                .setParameter(2, 678753)
                .setParameter(3, 4531.31)
                .setParameter(4, 20150630)
                .executeUpdate();
    }
}
