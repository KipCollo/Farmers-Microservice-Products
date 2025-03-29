package com.kipcollo.notifications.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kipcollo.notifications.model.Notification;

@Repository
public interface  NotificationRepository extends MongoRepository<Notification, String>{

}
