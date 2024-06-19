package com.ketankp.todo.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private String code;
    private String message;
    private String timestamp;
    private String path;
}
