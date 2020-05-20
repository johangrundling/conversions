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

    private static final BigDecimal KELVIN_CELSUIS_DIFF = new BigDecimal("273.15");

    private static final BigDecimal MILES_TO_KILOMETERS_FACTOR = new BigDecimal("1.609344");

    private static final BigDecimal KILOMETERS_TO_MILES_FACTOR = new BigDecimal("0.621371");

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
        return kelvin.subtract(KELVIN_CELSUIS_DIFF);
    }

    @GET
    @Path("/ctok/{celsuis}")
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal celsuisToKelvin(@PathParam("celsuis") BigDecimal celsuis) {
        log.info("ctok {} ", celsuis);
        return celsuis.add(KELVIN_CELSUIS_DIFF);
    }

    @GET
    @Path("/mtok/{miles}")
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal milesToKilometers(@PathParam("miles") BigDecimal miles) {
        log.info("mtok {} ", miles);
        return miles.multiply(MILES_TO_KILOMETERS_FACTOR);
    }

    @GET
    @Path("/ktom/{kilometers}")
    @Produces(MediaType.TEXT_PLAIN)
    public BigDecimal kilometerToMiles(@PathParam("kilometers") BigDecimal kilometers) {
        log.info("ktom {} ", kilometers);
        return kilometers.multiply(KILOMETERS_TO_MILES_FACTOR);
    }




}