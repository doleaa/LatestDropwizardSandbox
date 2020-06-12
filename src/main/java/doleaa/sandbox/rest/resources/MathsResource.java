package doleaa.sandbox.rest.resources;

import doleaa.sandbox.rest.dto.MathResultDto;
import doleaa.sandbox.rest.dto.Operations;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/math")
@Produces(MediaType.APPLICATION_JSON)
public class MathsResource {
    @GET
    @Path("/operation/{operationType}/{firstNumber}/{secondNumber}")
    public Response getSum(@PathParam("operationType") Operations operation, @PathParam("firstNumber") Integer firstNumber, @PathParam("secondNumber") Integer secondNumber) {
        return Response
                .ok(MathResultDto
                        .builder()
                        .operation(operation)
                        .result(operation.getResult(firstNumber, secondNumber))
                        .build())
                .build();
    }
}
