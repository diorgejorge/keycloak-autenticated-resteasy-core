package com.totvs.noneco.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by totvs on 31/08/2016.
 */
@ApplicationPath("/")
public class CoreKeyCloakApllication extends Application {
}
/**
 * recuperar token
 * RESULT=`curl --data "grant_type=password&client_id=basic-auth-service&username=user&password=password&client_secret=password" http://localhost:8080/auth/realms/basic-auth/protocol/openid-connect/token`
 * TOKEN=`echo $RESULT | sed 's/.*access_token":"//g' | sed 's/".*\//g'`
 * testar caminho seguro
 * curl localhost:8180/cobranca-service/service/versao -H "Authorization: bearer $TOKEN"
 * testar caminho livre
 *
 */
