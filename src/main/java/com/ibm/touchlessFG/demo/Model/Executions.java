package com.ibm.touchlessFG.demo.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document(collection = "Executions")
public class Executions implements ConfigurationModel {

	@Id
	@Field("ExecutionId")
	private UUID executionId;

	@Field("RunDate")
	private LocalDateTime runDate;

	@Field("ExecutionName")
	private String executionName;

	@Field("Modified")
	private LocalDateTime modified;

	@Field("ModifiedBy")
	private String modifiedBy;

	@Field("Created")
	private LocalDateTime created;

	@Field("CreatedBy")
	private String createdBy;

	@Field("Username")
	private String username;

	@Field("ExecutionStatus")
	private String executionstatus;

	@Field("FeatureFileName")
	private String featureFileName;

	@Field("EndDate")
	private LocalDateTime endDate;

	public Executions() {
	}

	@PersistenceConstructor
	public Executions(final UUID executionId, final LocalDateTime runDate, final String executionName,
			final LocalDateTime modified, final String modifiedBy, final LocalDateTime created, final String createdBy,
			final String username, final String executionstatus, final String featureFileName,
			final LocalDateTime endDate) {

		this.executionId = executionId;
		this.runDate = runDate;
		this.executionName = executionName;
		this.modified = modified;
		this.modifiedBy = modifiedBy;
		this.created = created;
		this.createdBy = createdBy;
		this.username = username;
		this.executionstatus = executionstatus;
		this.endDate = endDate;
		this.featureFileName = featureFileName;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	@JsonIgnore
	public UUID getId() {
		return executionId;
	}

	public UUID getExecutionId() {
		return executionId;
	}

	public String getExecutionName() {
		return executionName;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public LocalDateTime getRunDate() {
		return runDate;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public void setExecutionId(final UUID executionId) {
		this.executionId = executionId;
	}

	public void setExecutionName(final String executionName) {
		this.executionName = executionName;
	}

	public void setModified(final LocalDateTime modified) {
		this.modified = modified;
	}

	public void setModifiedBy(final String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setRunDate(final LocalDateTime admissiondate) {
		runDate = admissiondate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getExecutionstatus() {
		return executionstatus;
	}

	public void setExecutionstatus(final String executionstatus) {
		this.executionstatus = executionstatus;
	}

	public String getFeatureFileName() {
		return featureFileName;
	}

	public void setFeatureFileName(final String featureFileName) {
		this.featureFileName = featureFileName;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

}
