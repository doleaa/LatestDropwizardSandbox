package doleaa.sandbox.rest.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class MathResultDto implements Serializable {
    private Operations operation;
    private Integer result;

    public MathResultDto() {}
}
