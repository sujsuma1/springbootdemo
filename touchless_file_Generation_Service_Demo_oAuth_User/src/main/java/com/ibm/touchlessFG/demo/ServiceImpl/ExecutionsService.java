package com.ibm.touchlessFG.demo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.ibm.touchlessFG.demo.Dao.ExecutionsDAO;
import com.ibm.touchlessFG.demo.Model.Executions;

@Service
public class ExecutionsService {

	private final ExecutionsDAO dao;

	public ExecutionsService(final ExecutionsDAO dao) {
		this.dao = dao;
	}

	public Executions save(Executions request) {
		return dao.save(request);

	}
}
