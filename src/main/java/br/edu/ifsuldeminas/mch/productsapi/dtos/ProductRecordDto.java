package br.edu.ifsuldeminas.mch.productsapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank String name, @NotBlank String description, @NotNull Double price) {
}
