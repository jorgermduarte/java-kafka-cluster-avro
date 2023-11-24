package pt.jorgeduarte.javakafka.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.jorgeduarte.javakafka.domain.entities.Message;
import pt.jorgeduarte.javakafka.infrastructure.kafka.producers.MessageKafkaProducer;

@Service
public class KafkaService {
    @Autowired
    private MessageKafkaProducer _messageKafkaProducer;

    public void sendTestMessage(Message message) throws Exception {
        this._messageKafkaProducer.sendMessage(message);
    }
}
