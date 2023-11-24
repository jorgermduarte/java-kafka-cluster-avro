package pt.jorgeduarte.javakafka.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Message {
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String author;
}