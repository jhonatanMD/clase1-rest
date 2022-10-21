package com.ws.controller;

import com.ws.config.DataInfoProperties;
import com.ws.config.DataProperties;
import com.ws.model.dto.FruitDto;
import com.ws.service.IFruitService;
import com.ws.service.IValidationData;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1")
@RequiredArgsConstructor
public class AppController {


    @Inject
    @Named("fruit")
    private IFruitService fruitService;



    @ConfigProperty(name = "name")
    private String name;

    @ConfigProperty(name = "lastname")
    private String lastname;

    @ConfigProperty(name = "cod.error")
    private String codError;



    @Inject
    private DataProperties dataProperties;

    @Inject
    private DataInfoProperties dataInfoProperties;


    /*

    @GET    ->  @GETMAPPING
    @POST   ->  @POSTMAPPING
    @PUT    ->  @PUTMAPPING
    @PATH   ->  @PATHMAPPING
    @DELETE ->   @DELETEMAPPING
    @...

    */

    //@Inject //@Autowired => IFruitService fruitService = new FruitService();
    //private final IFruitService fruitService;



    /*
    @PostConstruct
    public void setUp(){
        fruitService = new FruitService();
    }*/

    /*
        public AppController(IFruitService fruitService) {
            this.fruitService = fruitService;
        }
    */



    @GET
    @Path("/response")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response response() {
       // return Response.ok().entity(name + " " + lastname + " - code-error " + codError).build();
       // return Response.ok().entity(dataProperties.name() + "  " + dataProperties.lastname() + " " + dataProperties.age() + " " + dataProperties.country()).build();
        return Response.ok().entity(dataInfoProperties.getName() + "  " + dataInfoProperties.getLastname() + " " + dataInfoProperties.getAge() + " " + dataInfoProperties.getCountry()).build();
    }


    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FruitDto> get() {
        return fruitService.findAll();
    }


    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(FruitDto fruit) {
        return Response.status(Response.Status.OK).entity(fruitService.save(fruit)).build();
    }


   @GET
   @Path("/get/id/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public String getById(@PathParam("id") Integer id) {
    return "Hello get id => " + id;
   }

    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String put() {
        return "Hello put";
    }

    @PATCH
    @Path("/patch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String patch() {
     return "patch";
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") Integer id) {
     return fruitService.delete(id) ? "SE ELIMINO CON EXITO" : "NO SE PUDO ELIMINAR FRUTA";
    }

}