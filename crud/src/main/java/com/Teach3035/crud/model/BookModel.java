package com.Teach3035.crud.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer publicationYear;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public BookModel(Long id, String title, Integer publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public BookModel(String title, Integer publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
//    public BookModel() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {

        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
