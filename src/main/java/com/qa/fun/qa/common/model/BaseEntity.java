package com.qa.fun.qa.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "CREATED_DATE_TIME", updatable = false)
	private LocalDateTime createdDateTime;

	@Column(name = "LAST_UPDATED_DATE_TIME")
	private LocalDateTime lastUpdatedDateTime;

	@PrePersist
	public void beforeCreate() {
		this.createdDateTime = LocalDateTime.now();
	}

	@PreUpdate
	public void beforeUpdate() {
		this.lastUpdatedDateTime = LocalDateTime.now();
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}
}
