package com.youzan.easyranking.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by paul on 15/10/9.
 */
public class AuditListener {

    @PrePersist
    public void prePersist(Object entity) {
        if(entity instanceof  Candidate) {
            ((Candidate) entity).setCreatedDate(new Timestamp((new Date()).getTime()));
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if(entity instanceof Candidate){
            ((Candidate)entity).setUpdatedDate(new Timestamp((new Date()).getTime()));
        }
    }
}
