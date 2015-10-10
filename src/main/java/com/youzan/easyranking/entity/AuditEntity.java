package com.youzan.easyranking.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by paul on 15/10/9.
 */
public class AuditEntity {

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;


    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
