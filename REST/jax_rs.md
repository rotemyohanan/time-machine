#### JAX-RS




JAX-RS provides some annotations to aid in mapping a resource class (a POJO) as a web resource. The annotations include:

    @Path specifies the relative path for a resource class or method.
    @GET, @PUT, @POST, @DELETE and @HEAD  // (specify the HTTP request type of a resource.)
    
    @Produces specifies the response Internet media types (used for content negotiation).
    @Consumes specifies the accepted request Internet media types.
In addition, it provides further annotations to method parameters to pull information out of the request. 
All the **@Param** annotations take a key of some form which is used to look up the value required.
    
    @PathParam binds the method parameter to a path segment.
    @QueryParam binds the method parameter to the value of an HTTP query parameter.
    @MatrixParam binds the method parameter to the value of an HTTP matrix parameter.
    @HeaderParam binds the method parameter to an HTTP header value.
    @CookieParam binds the method parameter to a cookie value.
    @FormParam binds the method parameter to a form value.
    @DefaultValue specifies a default value for the above bindings when the key is not found.
    @Context returns the entire context of the object (for example @Context HttpServletRequest request).

