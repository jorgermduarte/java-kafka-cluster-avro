package pt.jorgeduarte.javakafka.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pt.jorgeduarte.javakafka.domain.entities.Message;
import pt.jorgeduarte.javakafka.domain.services.KafkaService;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @Autowired
    private KafkaService _kafkaService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

    @GetMapping("/message")
    public ResponseEntity<String> test() throws Exception {
        var newMessage = Message.builder()
                .message("hello world")
                .author("Jorge Duarte")
                .title("test title")
                .createdAt(LocalDateTime.now())
                .build();

        _kafkaService.sendTestMessage(newMessage);
        return ResponseEntity.ok("Message sent successfully");
    }

}