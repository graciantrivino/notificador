package com.notificador.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.notificador.model.NotificadorRespuesta;

@WebService(serviceName = "InfoService2")
public interface InfoService {
	@WebMethod()
	@WebResult(name = "NotificadorRespuesta")
	public NotificadorRespuesta sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);
}
