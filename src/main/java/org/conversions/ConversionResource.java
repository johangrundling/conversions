package org.conversions;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;


@Slf4j
@Path("/conversions")
public class ConversionResource {

    private static final BigDecimal KELVIN_TO_CELSUIS = new BigDecimal("273.15");

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/ktoc/{kelvin}")
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal kelvinToCelsuis(@PathParam("kelvin") BigDecimal kelvin) {
        log.info("ktoc {} ", kelvin);
        return kelvin.subtract(KELVIN_TO_CELSUIS);
    }

    @GET
    @Path("/ctok/{celsuis}")
    @Produces(MediaType.TEXT_PLAIN)
    public String celsuisToKelvin(@PathParam("celsuis") String celsuis) {
        log.info("ctok {} ", celsuis);
        return "ctok " + celsuis;
    }

    @GET
    @Path("/mtok/{miles}")
    @Produces(MediaType.TEXT_PLAIN)
    public String milesToKilometers(@PathParam("miles") String miles) {
        log.info("mtok {} ", miles);
        return "mtok " + miles;
    }

    @GET
    @Path("/ktom/{kilometers}")
    @Produces(MediaType.TEXT_PLAIN)
    public String kilometerToMiles(@PathParam("kilometers") String kilometers) {
        log.info("ktom {} ", kilometers);
        return "ktom " + kilometers;
    }




}