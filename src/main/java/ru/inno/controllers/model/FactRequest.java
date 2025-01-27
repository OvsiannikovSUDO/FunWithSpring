package ru.inno.controllers.model;

import jakarta.validation.constraints.NotBlank;

public record FactRequest(@NotBlank String text) {
}
