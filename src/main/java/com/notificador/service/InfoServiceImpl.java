package com.notificador.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.notificador.model.NotificadorRespuesta;

@Service
public class InfoServiceImpl implements InfoService {

	@Override
	public NotificadorRespuesta sayHowAreYou(String name) {
		NotificadorRespuesta greeting = new NotificadorRespuesta();
		greeting.setMessage("How are you " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}
}
