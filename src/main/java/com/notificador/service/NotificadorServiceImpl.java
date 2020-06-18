package com.notificador.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.notificador.model.GfNotificacion;
import com.notificador.model.PePersonaEntidad;
import com.notificador.repositorios.PePersonaEntidadRepositorio;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.notificador.model.NotificadorRespuesta;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

@Service
public class NotificadorServiceImpl implements NotificadorService {
	@Autowired
	private PePersonaEntidadRepositorio perosonaentidadrepo;
	private static final Logger logger = Logger.getLogger(NotificadorServiceImpl.class);
	@Override
	public NotificadorRespuesta sayHello(String name) {
		NotificadorRespuesta notificadorRespuesta = new NotificadorRespuesta();
		notificadorRespuesta.setMessage("Hello " + name + "!!!");
		notificadorRespuesta.setDate(new Date());
		return notificadorRespuesta;
	}

	@Override
	public NotificadorRespuesta sayBye(String name) {
		NotificadorRespuesta notificadorRespuesta = new NotificadorRespuesta();
		notificadorRespuesta.setMessage("Bye " + name + "!!!");
		notificadorRespuesta.setDate(new Date());
		return notificadorRespuesta;
	}

	@Override
	public NotificadorRespuesta getNotificacion(String dni) {
		NotificadorRespuesta notificadorRespuesta = new NotificadorRespuesta();
		notificadorRespuesta.setMessage(dni);
		return notificadorRespuesta;
	}

	@Override
	public DataHandler downloadNotificacionPorDni ( String dni) throws IOException {
		// http://localhost:8080/services/
		// http://localhost:8080/services/NotificadorService?wsdl
		//  00000001R
		/*List<PePersonaEntidad> listapersonaentidad=perosonaentidadrepo.getPePersonaEntidadPorDni(dni);
		PePersonaEntidad personaentidad2=listapersonaentidad.iterator().next();*/
		PePersonaEntidad personaentidad=perosonaentidadrepo.getPePersonaEntidadPorDni(dni);
		List<GfNotificacion> listanotificaciones=perosonaentidadrepo.getGfNotificacion(personaentidad.getId_his_perso(), personaentidad.getId_perso());
		GfNotificacion notificacion=listanotificaciones.iterator().next();
		String pathNotificacion=perosonaentidadrepo.getNotificacioPdf(notificacion.getCod_archi());
		File archivo = new File (pathNotificacion);
		return new DataHandler(new FileDataSource(archivo));
	}


}
