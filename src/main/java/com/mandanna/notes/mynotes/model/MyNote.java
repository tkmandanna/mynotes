package com.mandanna.notes.mynotes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record MyNote(@Id Long id, String title, String content) {
}
