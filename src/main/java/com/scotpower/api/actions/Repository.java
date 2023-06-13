package com.scotpower.api.actions;

import com.scotpower.api.model.Electric;
import com.scotpower.api.model.Gas;
import com.scotpower.api.model.User;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface Repository {

    Optional<User> findUser(@NotNull Integer account_num);
    List<Object> findReadings(@NotNull Integer account_num);

    void insertUser();

    void insertReading();
}