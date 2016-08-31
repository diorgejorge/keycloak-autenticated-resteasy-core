package com.totvs.noneco.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by totvs on 31/08/2016.
 */

@Path("/service")
public class ServerUtils {
    @GET
    @Path("/versao")
    public String echo() {
        return buildTime();
    }

    private String buildTime(){
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

        Properties prop = new Properties();
        try {
            prop.load(input);

            return "Versao "+prop.getProperty("build.version") +" Construida em "+prop.getProperty("build.date")+" Usando java: "+prop.getProperty("build.java.version");
        } catch (IOException e) {
            return "";
        }

    }

    @GET
    @Path("teste")
    public Response teste() {
        return Response.ok().build();
    }
}