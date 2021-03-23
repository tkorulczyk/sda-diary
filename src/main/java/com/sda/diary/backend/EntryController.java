package com.sda.diary.backend;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EntryController {
    private final EntryService entryService;

    public String createNewEntry(String title, String content) {
        Entry newEntry = entryService.createNewEntry(title, content);
        return newEntry.toString();
    }

    public String readAllEntries() {
        entryService.readAllEntries();
        List<Entry> entries = entryService.readAllEntries();
        return entries.toString();
    }
}
