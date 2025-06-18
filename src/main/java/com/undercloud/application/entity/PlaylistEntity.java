package com.undercloud.application.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Playlist")
public class PlaylistEntity {
    @Id
    private String id;
    @NotBlank
    private String namePlaylist;
    @NotBlank
    private String coverUrl;
    @DBRef
    @NotBlank
    private List<SongEntity> songId;


}
