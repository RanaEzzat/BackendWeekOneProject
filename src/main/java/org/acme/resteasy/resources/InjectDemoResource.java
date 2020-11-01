package org.acme.resteasy.resources;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/demo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(
            @MatrixParam("param") String matrixParam,
            @HeaderParam("authSessionID") String header,
            @CookieParam("name") String cookie)
    {
        return "Matrix param: " + matrixParam + " Header Param: " +
                header + " Cookie "+ cookie;
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo,
                                        @Context HttpHeaders headers)
    {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "Path: "+path+" Cookies: "+cookies;
    }
}
