package com.totvs.noneco.rest


import javax.ws.rs.GET

/**
 * Created by totvs on 31/08/2016.
 */
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/service")
public class Utilities {
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

            return prop.getProperty("build.date");
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
