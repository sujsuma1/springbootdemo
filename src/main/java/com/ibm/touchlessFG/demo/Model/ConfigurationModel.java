package com.ibm.touchlessFG.demo.Model;

import java.util.UUID;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ConfigurationModel extends Persistable<UUID> {

	@Override
	@JsonIgnore
	default boolean isNew() {
		System.out.println("inside confirguration");
		return getId() == null;
	}

}
