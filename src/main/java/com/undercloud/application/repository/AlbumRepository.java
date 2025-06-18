package com.undercloud.application.repository;

import com.undercloud.application.entity.AlbumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlbumRepository extends MongoRepository<AlbumEntity, String> {

    @Query("{ 'album': ?0 }")
    List<AlbumEntity> searchAlbum(String albumName);
}
