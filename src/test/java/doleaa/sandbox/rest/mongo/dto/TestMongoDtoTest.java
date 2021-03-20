package doleaa.sandbox.rest.mongo.dto;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMongoDtoTest {

    @Test
    @SneakyThrows
    public void firstMongoConnectionTest() {
        //Given
        //TODO: Replace Secret
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://<secret>@cluster0-shard-00-00.2tjlj.mongodb.net:27017,cluster0-shard-00-01.2tjlj.mongodb.net:27017,cluster0-shard-00-02.2tjlj.mongodb.net:27017/myFirstDatabase?ssl=true&replicaSet=atlas-k1ayt5-shard-0&authSource=admin&retryWrites=true&w=majority"));
        MongoDatabase sandboxDb = mongoClient.getDatabase("sandbox_db");
        MongoCollection<Document> testCollection = sandboxDb.getCollection("testCollection");

        //When
        IntStream.rangeClosed(1, 20)
                .forEach((currentIndex) -> testCollection.insertOne(
                        TestMongoDto
                                .builder()
                                .testDocumentContent("some random content " + currentIndex)
                                .testOwnerNames(Arrays.asList("me", "myself", "and I"))
                                .build()
                                .toDocument()
                ));

        //Then
        assertThat(testCollection.count()).isEqualTo(20);
        testCollection.deleteMany(new Document());
        assertThat(testCollection.count()).isEqualTo(0);
    }
}
