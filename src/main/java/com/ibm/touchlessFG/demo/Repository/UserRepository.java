package com.ibm.touchlessFG.demo.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.touchlessFG.demo.Model.Users;


@Repository
public interface UserRepository extends MongoRepository<Users, UUID> {

	List<Users> findByUserId(UUID fromString);
	Users findOneByUserName(String userName );

}
