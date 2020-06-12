package doleaa.sandbox.rest.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathResultDtoTest {
    private static final Operations operation = Operations.SUM;
    private static final Integer firstNumber = 4;
    private static final Integer secondNumber = 5;

    @Test
    public void builder_whenCalled_thenCreatesFullyFormedObject() {
        //Given
        Integer expectedResult = 9;
        Operations expectedOperation = Operations.SUM;


        //When
        MathResultDto actual = MathResultDto
                .builder()
                .operation(operation)
                .result(operation.getResult(firstNumber, secondNumber))
                .build();


        //Then
        assertThat(actual.getOperation()).isEqualTo(expectedOperation);
        assertThat(actual.getResult()).isEqualTo(expectedResult);
    }
}
