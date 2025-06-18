package com.undercloud.application.repository;

import com.undercloud.application.entity.PlaylistEntity;
import com.undercloud.application.entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<PlaylistEntity, String> {
}
