package com.sda.diary.backend;

import com.sda.diary.exception.BadRequestException;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class EntryService {
    private final EntryRepository entryRepository;
    private final TimeClient timeClient;
    private static final Logger LOGGER = Logger.getLogger(EntryService.class.getName());

    public EntryService(EntryRepository entryRepository, TimeClient timeClient) {
        this.entryRepository = Objects.requireNonNull(entryRepository, "EntryRepository cannot be null");
        this.timeClient = Objects.requireNonNull(timeClient, "TimeClient cannot be null");
    }

    Entry createNewEntry(String title, String content) {
        validateInput(title, "The title cannot be empty");
        validateInput(content, "Content cannot be empty");

        Instant now = timeClient.getCurrentTime();
        Entry entry = new Entry(title, content, now);
        LOGGER.info("Saving entry to DB");
        return entryRepository.saveEntry(entry);
    }

    List<Entry> readAllEntries() {
        return entryRepository.readAllEntries();
    }

    private void validateInput(String input, String errorMessage) {
        Objects.requireNonNull(input, errorMessage);
        if (input.isBlank()) {
            throw new BadRequestException(errorMessage);
        }
    }
}
