package com.tapusd.reactivecassandra.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Nullable;
import java.time.LocalDate;

public record AuthorDTO(String name, String imageUrl, String biography, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth, @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfDeath) {
}
