package com.notificador.repositorios;


import com.notificador.model.GfNotificacion;
import com.notificador.model.PePersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PePersonaEntidadRepositorio extends JpaRepository<PePersonaEntidad, String> {
    /*
    Con el DNI/CIF del certificado debes de buscar en pe_persona_entidad:
   Select id_his_perso, id_perso from pe_persona_entidad where num_docum='XXXXXXXX' and reg_activ=1 and cod_movim<>'B'
   Con los ids, buscas en pe_notificacion para enviada, recepcionada.
   select id_notif, cod_archi from gf_notificacion where id_his_perso=XX and id_perso=XX and situacion in (2, 3)
   Por último buscas en ge_archivo su pdf (recuerda que los pdfs de la notificación sólo se van a descargar cuando te firmen el acuse de recibo:
   select des_archi from ge_archivo where cod_archiv=XX
     */


    @Query("Select pe from PePersonaEntidad as pe where pe.num_docum=:dni and reg_activ=1 and cod_movim<>'B'")
    List<PePersonaEntidad> getListaPePersonaEntidadPorDni(@Param("dni") String dni);

    @Query("Select pe from PePersonaEntidad as pe where pe.num_docum=:dni")
    PePersonaEntidad getPePersonaEntidadPorDni(@Param("dni") String dni);

    @Query("Select gfn from GfNotificacion as gfn where gfn.id_his_perso=:id_his_perso and gfn.id_perso=:id_perso")
    List<GfNotificacion> getGfNotificacion(@Param("id_his_perso") long id_his_perso, @Param("id_perso") long id_perso);

    @Query("Select gea.des_archi from GeArchivo gea where gea.cod_archi=:cod_archi")
    String getNotificacioPdf(@Param("cod_archi") long cod_archi);

}


