package com.notificador.service;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import com.notificador.model.NotificadorRespuesta;

import java.io.IOException;

@WebService(serviceName = "NotificadorService")
@MTOM
public interface NotificadorService {

	@WebMethod()
	@WebResult(name = "Greeting")
	public NotificadorRespuesta sayHello(@WebParam(name = "GreetingsRequest") String name);

	@WebMethod()
	@WebResult(name = "Greeting")
	public NotificadorRespuesta sayBye(@WebParam(name = "GreetingsRequest") String name);

	@WebMethod()
	@WebResult(name = "Notificacion")
	public NotificadorRespuesta getNotificacion(@WebParam(name = "dni") String dni);

	@WebMethod()
	@WebResult(name = "Notificacion")
	DataHandler downloadNotificacionPorDni(@WebParam(name = "dni") String dni) throws IOException;
}
