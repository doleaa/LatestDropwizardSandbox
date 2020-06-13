package doleaa.sandbox.rest.mongo.dto;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMongoDtoTest {

    @Test
    @SneakyThrows
    public void firstMongoConnectionTest() {
        //Given
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
        MongoDatabase sandboxDb = mongoClient.getDatabase("sandbox_db");
        MongoCollection<Document> testCollection = sandboxDb.getCollection("testCollection");

        //When
        IntStream.rangeClosed(1, 20)
                .forEach((currentIndex) -> testCollection.insertOne(
                        TestMongoDto
                                .builder()
                                .testDocumentContent("some random content " + currentIndex)
                                .build()
                                .toDocument()
                ));

        //Then
        assertThat(testCollection.count()).isEqualTo(20);
        testCollection.deleteMany(new Document());
        assertThat(testCollection.count()).isEqualTo(0);
    }
}
