package doleaa.sandbox.rest.mongo.dto;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.*;
import org.bson.Document;
import org.bson.types.ObjectId;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class TestMongoDto {
    private ObjectId documentId;
    private String testDocumentContent;

    TestMongoDto() {}

    public DBObject toDBObject() {
        BasicDBObject returnable = new BasicDBObject("content", this.testDocumentContent);

        if (this.documentId != null) {
            return returnable.append("_id", this.documentId);
        }

        return returnable;
    }
    public static TestMongoDto fromDBObject(DBObject givenObject) {
        return TestMongoDto
                .builder()
                .documentId((ObjectId) givenObject.get("_id"))
                .testDocumentContent((String) givenObject.get("content"))
                .build();
    }

    public Document toDocument() {
        Document returnable = new Document("content", this.testDocumentContent);

        if (this.documentId != null) {
            return returnable.append("_id", this.documentId);
        }

        return returnable;
    }
    public static TestMongoDto fromDocument(Document givenDocument) {
        return TestMongoDto
                .builder()
                .documentId(givenDocument.getObjectId("_id"))
                .testDocumentContent(givenDocument.getString("content"))
                .build();
    }
}
