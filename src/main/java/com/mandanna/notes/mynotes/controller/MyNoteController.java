package com.mandanna.notes.mynotes.controller;

import com.mandanna.notes.mynotes.model.MyNote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyNoteController {

    @GetMapping("/cashcards/{requestedId}")
    private ResponseEntity<MyNote> findNoteById(@PathVariable Long requestedId){
        MyNote myNote = new MyNote(1L,"abc","hello world");
        return ResponseEntity.ok(myNote);
    }
}
