package doleaa.sandbox.rest.mongo.entities;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import lombok.*;
import org.bson.types.ObjectId;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Book {
    @Id
    private ObjectId objectId;
    private String title;
    @Property("price")
    private double retailPrice;
    @Property("cost")
    private double manufacturingPrice;
}
