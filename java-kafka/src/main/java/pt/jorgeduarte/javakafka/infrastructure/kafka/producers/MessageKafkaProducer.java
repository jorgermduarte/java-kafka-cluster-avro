package pt.jorgeduarte.javakafka.infrastructure.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import pt.jorgeduarte.MessageAvro;
import pt.jorgeduarte.javakafka.domain.entities.Message;

@Service
public class MessageKafkaProducer {
    private static final String TOPIC = "message-topic-example";
    private static final Integer SCHEMA_ID = 1;
    @Autowired
    private KafkaTemplate<String, MessageAvro> kafkaTemplate;

    public MessageKafkaProducer(KafkaTemplate<String, MessageAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
    }

    private MessageAvro convertToAvro(Message message){
        return MessageAvro.newBuilder()
                .setTitle(message.getTitle())
                .setMessage(message.getMessage())
                .setCreatedAt(message.getCreatedAt().toString())
                .setAuthor(message.getAuthor())
                .build();
    }

    // TODO: implement this method
    // private object getAvroSchemaFromRegistry(){
    // }

    // TODO: based on the avro from the registry, lets validate it
    private boolean isValidSchema(MessageAvro message){
        return true;
    }

    public void sendMessage(Message message) throws Exception {
       MessageAvro avroMessage = convertToAvro(message);

       if (isValidSchema(avroMessage)) {
           // TODO: currently is throwing an error ( probably wrong dependencies )
           kafkaTemplate.send(TOPIC, avroMessage);
       } else {
            throw new Exception("Invalid message provided");
       }
    }
}