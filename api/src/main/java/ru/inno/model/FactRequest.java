package ru.inno.model;

import jakarta.validation.constraints.NotBlank;

public record FactRequest(@NotBlank String text) {
}
