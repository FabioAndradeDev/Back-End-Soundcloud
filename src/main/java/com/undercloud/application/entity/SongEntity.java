package com.undercloud.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Songs")
public class SongEntity {
    @Id
    private String id;
    private String songName;
    private String coverUrl;
    private Date releaseDate;
    private Long duration;
    private Long plays;
    @DBRef
    private List<UsersEntity> artistId;

}
