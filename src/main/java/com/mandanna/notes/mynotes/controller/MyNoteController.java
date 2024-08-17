package com.mandanna.notes.mynotes.controller;

import com.mandanna.notes.mynotes.model.MyNote;
import com.mandanna.notes.mynotes.repository.MyNoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MyNoteController {

    private final MyNoteRepository myNoteRepository;

    private MyNoteController(MyNoteRepository myNoteRepository){
        this.myNoteRepository = myNoteRepository;
    }

    @GetMapping("/mynotes/{requestedId}")
    private ResponseEntity<MyNote> findNoteById(@PathVariable Long requestedId){
        System.out.println("In FindNoteById for id = "+requestedId);
        Optional<MyNote> myNoteOptional = myNoteRepository.findById(requestedId);
        for (MyNote myNote : myNoteRepository.findAll()){
            System.out.println("myNote = "+myNote.toString());
        }
        return myNoteOptional
                .map(myNote -> ResponseEntity.ok(myNote))
                .orElse(ResponseEntity.notFound().build());

    }
}
