package com.scotpower.api.model;

import io.micronaut.serde.annotation.Serdeable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Serdeable
@Entity
@Table(name = "GAS_READINGS")
public class Gas {

    public Gas() {}

    public Gas(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    @Column(name = "meter_id")
    private Long meter_id;

    @Column(name = "reading")
    private Float reading;

    @Column(name = "recorded")
    private Integer recorded;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getMeterID() {
        return meter_id;
    }

    public Float getReading() {
        return reading;
    }

    public Integer getRecorded() {
        return recorded;
    }
}