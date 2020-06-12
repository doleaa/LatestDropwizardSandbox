package doleaa.sandbox.rest.dto;

public enum Operations {
    SUM("Sum"){
        @Override
        public Integer getResult(Integer leftHandValue, Integer rightHandValue) {
            return leftHandValue + rightHandValue;
        }
    },
    DIVISION("Division"){
        @Override
        public Integer getResult(Integer leftHandValue, Integer rightHandValue) {
            return leftHandValue - rightHandValue;
        }
    };

    Operations(String givenOperationName) {
        this.returnableOperationName = givenOperationName;
    }
    private String returnableOperationName;
    public Integer getResult(Integer leftHandValue, Integer rightHandValue) { return 0; }
}
