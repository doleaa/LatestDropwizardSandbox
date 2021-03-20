package doleaa.sandbox.rest.mongo.dto;

import lombok.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class TestMongoDto {
    private ObjectId documentId;
    private String testDocumentContent;
    private List<String> testOwnerNames;

    TestMongoDto() {}

    public Document toDocument() {
        Document returnable = new Document();

        returnable
                .append("content", this.testDocumentContent)
                .append("ownerNames", this.testOwnerNames);

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
                //Will this unchecked assignment work? Hm...
//                .testOwnerNames(givenDocument.get("ownerNames", List.class))
                .build();
    }
}
