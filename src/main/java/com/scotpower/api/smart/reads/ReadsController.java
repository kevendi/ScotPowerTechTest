package com.scotpower.api.smart.reads;

import com.scotpower.api.actions.Repository;
import com.scotpower.api.model.Gas;
import com.scotpower.api.model.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import java.util.List;
import java.util.Optional;

@Controller("/api/smart/reads")
public class ReadsController {

    private final Repository repository;

    public ReadsController(Repository repository) {
        this.repository = repository;
    }

    public void init() {}

    @Get("get/{account_num}")
    public List<Object> reads(@PathVariable Integer account_num) {
        return repository.findReadings(account_num);
    }

    @Get("user/{account_num}")
    public Optional<User> getUser(@PathVariable Integer account_num) {
        return repository.findUser(account_num);
    }

    @Post("/insert_user")
    public void insertUser() {
        repository.insertUser();
    }

    @Post("/insert_reading")
    public void insertReading() {
        repository.insertReading();
    }
}
