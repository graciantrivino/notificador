package com.notificador.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pe_persona_entidad")
@EntityListeners(AuditingEntityListener.class)
public class PePersonaEntidad implements Serializable {

@Id
    @Column(name = "id_his_perso")
    private long id_his_perso;
    @Column(name = "id_perso")
    private long id_perso;
    @Column(name = "num_docum")
    private String num_docum;
    @Column(name = "reg_activ")
    private int reg_activ;
    @Column(name = "cod_movim")
    private char cod_movim;

    public long getId_perso() {
        return id_perso;
    }

    public void setId_perso(long id_perso) {
        this.id_perso = id_perso;
    }

    public long getId_his_perso() {
        return id_his_perso;
    }

    public void setId_his_perso(long id_his_perso) {
        this.id_his_perso = id_his_perso;
    }

    public String getNum_docum() {
        return num_docum;
    }

    public void setNum_docum(String num_docum) {
        this.num_docum = num_docum;
    }

    public int getReg_activ() {
        return reg_activ;
    }

    public void setReg_activ(int reg_activ) {
        this.reg_activ = reg_activ;
    }

    public char getCod_movim() {
        return cod_movim;
    }

    public void setCod_movim(char cod_movim) {
        this.cod_movim = cod_movim;
    }
}
