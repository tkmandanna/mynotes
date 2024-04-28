package com.mandanna.notes.mynotes;

import com.mandanna.notes.mynotes.model.MyNote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@JsonTest
public class MyNoteJsonTest {

    @Autowired
    private JacksonTester<MyNote> myNoteJson;

    @Test
    void myNoteSerializationTest()throws IOException{
        MyNote myNote = new MyNote(1L,"Hello", "World");
        assertThat(myNoteJson.write(myNote)).isStrictlyEqualToJson("expected.json");
    }

    @Test
    void myNoteDeSerializationTest()throws IOException{
        String expected = """
                {
                  "id": 1,
                  "title": "Hello",
                  "content": "World"
                }
                """;
        MyNote myNote = new MyNote(1L,"Hello", "World");
        assertThat(myNoteJson.parse(expected)).isEqualTo(myNote);
        assertThat(myNoteJson.parseObject(expected).id()).isEqualTo(1L);
        assertThat(myNoteJson.parseObject(expected).title()).isEqualTo("Hello");
        assertThat(myNoteJson.parseObject(expected).content()).isEqualTo("World");

    }
}
