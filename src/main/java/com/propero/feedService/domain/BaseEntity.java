package com.propero.feedService.domain;

import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@ToString
public abstract class BaseEntity {



    @Column(updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;


    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdOn;


    @Column(nullable = false)
    @LastModifiedBy
    private String modifiedBy;


    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedOn;

}