package com.ibm.touchlessFG.demo.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ibm.touchlessFG.demo.Model.Users;

@Repository
public class UserDao {
	private final MongoTemplate mongoTemplate;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public UserDao(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public Users findOneByName(String userId) {

		// Binary originalUUID = Converter.toStandardBinaryUUID(userId);

		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userId));
		Users user = mongoTemplate.findOne(query, Users.class);
		return user;
	}

}
