package com.sda.diary.backend;

import com.sda.diary.exception.BadRequestException;

import java.time.Instant;
import java.util.List;

public class EntryService {
    private final EntryRepository entryRepository;
    private final TimeClient timeClient;

    public EntryService(EntryRepository entryRepository, TimeClient timeClient) {
        this.entryRepository = entryRepository;
        this.timeClient = timeClient;
    }

    Entry createNewEntry(String title, String content) {
        if(isBlank(title) || isNull(title)) {
            throw new BadRequestException("The title cannot be empty");
        }
        if(isBlank(content) || isNull(content)) {
            throw new BadRequestException("Content cannot be empty");
        }

        Instant now = timeClient.getCurrentTime();
        Entry entry = new Entry(title, content, now);
        return entryRepository.saveEntry(entry);
    }

    List<Entry> readAllEntries() {
        return entryRepository.readAllEntries();
    }



    private boolean isNull(String... args) {
        for (String arg : args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlank(String... args) {
        for (String arg : args) {
            if (arg.isBlank()) {
                return true;
            }
        }
        return false;
    }
}
