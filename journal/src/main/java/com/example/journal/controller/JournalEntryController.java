package com.example.journal.controller;
import com.example.journal.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return "Entry added";
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable String id , @RequestBody JournalEntry entity) {
        journalEntries.put(Long.parseLong(id), entity); 
        return entity;
    }

    @DeleteMapping("/{id}")
    public boolean deleteEntry(@PathVariable String id){
        journalEntries.remove(Long.parseLong(id));
        return true;
    }
    

    
}
