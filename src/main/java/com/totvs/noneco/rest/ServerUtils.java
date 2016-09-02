package com.totvs.noneco.rest;


import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
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
@Stateless
public class ServerUtils {

    /**
     * Used to check server info
     * @return {@link String} with version, build date and java version used on compilation
     */
    @GET
    @Path("/version")
    @RolesAllowed("admin")
    public String version() {
        return buildTime();
    }

    private String buildTime(){
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

        Properties prop = new Properties();
        try {
            prop.load(input);

            return "Version: "+prop.getProperty("build.version") +" Build in "+prop.getProperty("build.date")+" Using java version: "+prop.getProperty("build.java.version");
        } catch (IOException e) {
            return "";
        }

    }

    /**
     * Server availability check
     * @return returns Response.ok() = 200
     */
    @GET
    @Path("teste")
    @RolesAllowed("user")
    public Response teste() {
        return Response.ok().build();
    }
}
