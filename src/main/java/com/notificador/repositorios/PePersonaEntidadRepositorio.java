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



    @Query("Select pe from PePersonaEntidad as pe where pe.num_docum=:dni and reg_activ=1 and cod_movim<>'B'")
    List<PePersonaEntidad> getListaPePersonaEntidadPorDni(@Param("dni") String dni);

    @Query("Select pe from PePersonaEntidad as pe where pe.num_docum=:dni")
    PePersonaEntidad getPePersonaEntidadPorDni(@Param("dni") String dni);

    @Query("Select gfn from GfNotificacion as gfn where gfn.id_his_perso=:id_his_perso and gfn.id_perso=:id_perso")
    List<GfNotificacion> getGfNotificacion(@Param("id_his_perso") long id_his_perso, @Param("id_perso") long id_perso);

    @Query("Select gea.des_archi from GeArchivo gea where gea.cod_archi=:cod_archi")
    String getNotificacioPdf(@Param("cod_archi") long cod_archi);

}


