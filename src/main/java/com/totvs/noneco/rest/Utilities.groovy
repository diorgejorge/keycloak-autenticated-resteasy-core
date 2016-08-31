package com.totvs.noneco.rest

import org.jboss.resteasy.annotations.cache.NoCache

import javax.ws.rs.GET

/**
 * Created by totvs on 31/08/2016.
 */
import javax.ws.rs.Path

@Path("service")
public class Utilities {
    @GET
    @NoCache
    @Path("versao")
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
    @NoCache
    @Path("teste")
    public String teste() {
        return "OK";
    }
}
