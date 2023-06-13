package com.scotpower.api.model;

import io.micronaut.serde.annotation.Serdeable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Serdeable
@Entity
@Table(name = "ELEC_READINGS")
public class Electric {

    public Electric() {}

    public Electric(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    @Column(name = "meter_id")
    private Long meter_id;

    @Column(name = "reading")
    private Float reading;

    @Column(name = "recorded")
    private Date recorded;

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

    public Date getRecorded() {
        return recorded;
    }
}