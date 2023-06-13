package com.scotpower.api.model;

import io.micronaut.serde.annotation.Serdeable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Serdeable
@Entity
@Table(name = "users")
public class User {

    public User() {}

    public User(Integer account_number) {
        this.account_number = account_number;
    }

    @Id
    private Integer account_number;

    @Column(name = "since")
    private Integer since;

    @Column(name = "gas")
    private Boolean gas;

    @Column(name = "electric")
    private Boolean electric;

    @Column(name = "name")
    private String name;

    @Column(name = "meter_id")
    private Long meter_id;

    public Integer getAccountNumber() {
        return account_number;
    }

    public void setAccountNumber(Integer account_number) {
        this.account_number = account_number;
    }

    public Integer getSince() {
        return since;
    }

    public Boolean getGas() {
        return gas;
    }

    public Boolean getElectric() {
        return electric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMeterID() {
        return meter_id;
    }
}