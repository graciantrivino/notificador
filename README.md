# Notificador

   
  Con el DNI/CIF del certificado debes de buscar en pe_persona_entidad:
  
    Select id_his_perso, id_perso from pe_persona_entidad where num_docum='XXXXXXXX' and reg_activ=1 and cod_movim<>'B'
  
   Con los ids, buscas en pe_notificacion para enviada, recepcionada.
   
     select id_notif, cod_archi from gf_notificacion where id_his_perso=XX and id_perso=XX and situacion in (2, 3)
  
   Por último buscas en ge_archivo su pdf (recuerda que los pdfs de la notificación sólo se van a descargar cuando te firmen el acuse de recibo:
   
    select des_archi from ge_archivo where cod_archiv=XX
    
   URL para obtener las direcciones wsdl
   
    http://localhost:8080/services/
   
   WSDL
   
    http://localhost:8080/services/NotificadorService?wsdl
   
   DNI de Prueba
   
     00000001R
     
  