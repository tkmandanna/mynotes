package com.mandanna.notes.mynotes.model;

import org.springframework.data.annotation.Id;

public record MyNote(@Id Long id, String title, String content) {
}
