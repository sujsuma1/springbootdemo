package com.ibm.touchlessFG.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.touchlessFG.demo.Model.Executions;


@Repository
public interface ExecutionsRepository extends MongoRepository<Executions, UUID> {

	List<Executions> findByUsernameAndExecutionIdInAndRunDateGreaterThan(String userId, List<UUID> executionIds,
			Date startDate);
}
