package com.undercloud.application.repository;

import com.undercloud.application.entity.SongEntity;
import com.undercloud.application.entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<SongEntity, String> {
}
