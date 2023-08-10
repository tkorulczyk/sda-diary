package com.sda.diary.backend;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Instant createdDate;

    public Entry(String title, String content, Instant createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "\nEntry {id = " + id +
                ", title = '" + title + '\'' +
                ", content = '" + content + '\'' +
                ", createdDate = " + createdDate + '}';
    }
}
