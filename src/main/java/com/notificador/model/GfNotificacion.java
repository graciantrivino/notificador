package com.notificador.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gf_notificacion")
@EntityListeners(AuditingEntityListener.class)
public class GfNotificacion implements Serializable {

    @Id
    @Column(name = "id_his_perso")
    private long id_his_perso;
    @Column(name = "id_perso")
    private long id_perso;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "situacion")
    private int situacion;
    @Column(name = "cod_archi")
    private long cod_archi;


    public long getId_his_perso() {
        return id_his_perso;
    }

    public void setId_his_perso(long id_his_perso) {
        this.id_his_perso = id_his_perso;
    }

    public long getId_perso() {
        return id_perso;
    }

    public void setId_perso(long id_perso) {
        this.id_perso = id_perso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public long getCod_archi() {
        return cod_archi;
    }

    public void setCod_archi(long cod_archi) {
        this.cod_archi = cod_archi;
    }
}
