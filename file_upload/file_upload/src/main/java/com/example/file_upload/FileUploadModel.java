package com.example.file_upload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "ImageProfile")
public class FileUploadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Lob
    @Column(name = "Image")
    private byte[] image;

    public FileUploadModel(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }
}