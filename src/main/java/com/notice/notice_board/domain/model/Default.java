package com.notice.notice_board.domain.model;

import jakarta.persistence.Column;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public class Default {

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @SoftDelete(columnName = "is_deleted") //soft delete 어노테이션

    @Column(name = "is_deleted", insertable = false, updatable = false)
    private boolean isDeleted;
}
