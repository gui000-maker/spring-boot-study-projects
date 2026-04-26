package com.example.accessingdatajpa.dto;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String firstName,
        String lastName,
        LocalDateTime createdAt
) {}