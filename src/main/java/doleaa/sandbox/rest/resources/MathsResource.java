package doleaa.sandbox.rest.resources;

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
    @Path("/sum/{firstNumber}/{secondNumber}")
    public Response getSum(@PathParam("firstNumber") Integer firstNumber, @PathParam("secondNumber") Integer secondNumber) {
        return Response
                .ok(firstNumber + secondNumber)
                .build();
    }
}
