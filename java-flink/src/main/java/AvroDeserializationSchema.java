import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import pt.jorgeduarte.MessageAvro;

import java.io.IOException;

public class AvroDeserializationSchema implements DeserializationSchema<MessageAvro> {

    @Override
    public MessageAvro deserialize(byte[] message) throws IOException {
        SpecificDatumReader<MessageAvro> datumReader = new SpecificDatumReader<>(MessageAvro.class);
        Decoder decoder = DecoderFactory.get().binaryDecoder(message, null);
        return datumReader.read(null, decoder);
    }

    @Override
    public boolean isEndOfStream(MessageAvro nextElement) {
        return false;
    }

    @Override
    public TypeInformation<MessageAvro> getProducedType() {
        return TypeInformation.of(MessageAvro.class);
    }
}
