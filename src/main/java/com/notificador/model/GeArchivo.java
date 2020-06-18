package com.notificador.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ge_archivo")
@EntityListeners(AuditingEntityListener.class)
public class GeArchivo implements Serializable {

    @Id
    @Column(name = "cod_archi")
    private long cod_archi;
    @Column(name = "des_archi")
    private String des_archi;

    public long getCod_archi() {
        return cod_archi;
    }

    public void setCod_archi(long cod_archi) {
        this.cod_archi = cod_archi;
    }

    public String getDes_archi() {
        return des_archi;
    }

    public void setDes_archi(String des_archi) {
        this.des_archi = des_archi;
    }
}