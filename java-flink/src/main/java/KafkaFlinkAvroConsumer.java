import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import pt.jorgeduarte.MessageAvro;

import java.util.Properties;

public class KafkaFlinkAvroConsumer {
    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        //properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("bootstrap.servers", "kafka-broker1:9092");
        properties.setProperty("group.id", "test");

        FlinkKafkaConsumer<MessageAvro> consumer = new FlinkKafkaConsumer<>(
                "message-topic-example",
                new AvroDeserializationSchema(),
                properties);

        DataStream<MessageAvro> stream = env.addSource(consumer);

        stream.print();

        env.execute("Kafka Flink Avro Consumer");
    }
}

