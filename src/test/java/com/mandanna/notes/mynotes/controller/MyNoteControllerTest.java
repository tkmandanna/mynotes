package com.mandanna.notes.mynotes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandanna.notes.mynotes.model.MyNote;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class MyNoteControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void shouldNotReturnNoteForUnknownId(){

        ResponseEntity<MyNote> response = restTemplate.getForEntity("/mynotes/99",MyNote.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.hasBody()).isEqualTo(false);
    }

    @Test
    public void shouldReturnNoteForKnowId() throws IOException {
        ResponseEntity<MyNote> response = restTemplate.getForEntity("/mynotes/1",MyNote.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        InputStream inJson = MyNote.class.getResourceAsStream("src/test/resources/expected.json");
        MyNote myNoteExpected = new ObjectMapper().readValue(inJson, MyNote.class);

        MyNote myNoteReceived = response.getBody();
        assertThat(myNoteReceived.id()).isEqualTo(myNoteExpected.id());
        assertThat(myNoteReceived.content()).isEqualTo(myNoteExpected.content());
        assertThat(myNoteReceived.title()).isEqualTo(myNoteExpected.title());
    }


}