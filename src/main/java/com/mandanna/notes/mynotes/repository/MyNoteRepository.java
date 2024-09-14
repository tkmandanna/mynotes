package com.mandanna.notes.mynotes.repository;

import com.mandanna.notes.mynotes.model.MyNote;
import org.springframework.data.repository.CrudRepository;

public interface MyNoteRepository extends CrudRepository<MyNote, Long>{
}
