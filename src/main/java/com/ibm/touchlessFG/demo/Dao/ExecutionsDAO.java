package com.ibm.touchlessFG.demo.Dao;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ibm.touchlessFG.demo.Model.Executions;
import com.ibm.touchlessFG.demo.Repository.ExecutionsRepository;

@Component
public class ExecutionsDAO {

	private final ExecutionsRepository repository;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public ExecutionsDAO(final ExecutionsRepository repository) {
		this.repository = repository;
	}

	public Executions save(Executions request) {
		if (null == request.getExecutionId()) {
			request.setCreated(LocalDateTime.now());
			request.setRunDate(LocalDateTime.now());
		}
		request.setModified(LocalDateTime.now());
		return repository.save(request);
	}

}
