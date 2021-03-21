package doleaa.sandbox.rest.mongo.entities;

import com.mongodb.*;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    @Test
    @SneakyThrows
    public void firstMorphiaEntityTest() {
        //Given
        Morphia morphia = new Morphia();
        morphia.mapPackage("doleaa.sandbox.rest.mongo.entities");
        Datastore datastore = morphia.createDatastore(
                new MongoClient(new MongoClientURI("mongodb://<secret>@cluster0-shard-00-00.2tjlj.mongodb.net:27017,cluster0-shard-00-01.2tjlj.mongodb.net:27017,cluster0-shard-00-02.2tjlj.mongodb.net:27017/myFirstDatabase?ssl=true&replicaSet=atlas-k1ayt5-shard-0&authSource=admin&retryWrites=true&w=majority")),
                "testLibrary"
        );
        datastore.ensureIndexes();

        //When
        datastore.save(
                Book.builder()
                        .objectId(new ObjectId())
                        .title("testTitle")
                        .retailPrice(12)
                        .manufacturingPrice(4)
                        .build()
        );
        List<Book> persistedBooks = datastore.createQuery(Book.class)
                .field("title")
                .contains("test")
                .find()
                .toList();


        //Then
        assertThat(persistedBooks.size()).isEqualTo(1);
        System.out.println(persistedBooks);

        Query<Book> query = datastore.createQuery(Book.class)
                .field("title")
                .contains("test");
        datastore.delete(query);

        persistedBooks = datastore.createQuery(Book.class)
                .field("title")
                .contains("test")
                .find()
                .toList();
        assertThat(persistedBooks.size()).isEqualTo(0);
    }
}
