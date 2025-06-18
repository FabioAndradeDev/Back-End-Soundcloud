package com.undercloud.application.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Album")
public class AlbumEntity {
    @Id
    private String id;
    @NotBlank
    private String albumName;
    @DBRef
    @NotBlank
    private List<SongEntity> songsId;
}
