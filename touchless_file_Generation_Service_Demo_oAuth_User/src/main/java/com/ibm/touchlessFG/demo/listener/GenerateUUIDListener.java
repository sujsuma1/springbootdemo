package com.ibm.touchlessFG.demo.listener;

import java.lang.reflect.Field;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.ibm.touchlessFG.demo.Model.ConfigurationModel;


@Component
public class GenerateUUIDListener extends AbstractMongoEventListener<ConfigurationModel> {

	@Override
	public void onBeforeConvert(final BeforeConvertEvent<ConfigurationModel> event) {
		if (event.getSource().isNew()) {
			for (final Field field : event.getSource().getClass().getDeclaredFields()) {
				if(field.isAnnotationPresent(Id.class)) {
					field.setAccessible(true);
					try {
						field.set(event.getSource(), UUID.randomUUID());
						break;
					} catch (final Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
