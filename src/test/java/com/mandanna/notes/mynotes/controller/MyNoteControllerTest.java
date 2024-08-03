package com.mandanna.notes.mynotes.controller;

import com.mandanna.notes.mynotes.model.MyNote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyNoteControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void shouldNotReturnNoteForUnknownId(){

        ResponseEntity<MyNote> response = restTemplate.getForEntity("/cashcards/99",MyNote.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.hasBody()).isEqualTo(false);
    }



}