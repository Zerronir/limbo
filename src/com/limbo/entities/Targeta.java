package com.limbo.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Targeta {
    int id, codi_seguretat, client_id;
    Long numero;
    String tipus;

    Date data_caducitat;

    public Date getData_caducitat() {
        return data_caducitat;
    }

    public void setData_caducitat(Date data_caducitat) {
        this.data_caducitat = data_caducitat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodi_seguretat() {
        return codi_seguretat;
    }

    public void setCodi_seguretat(int codi_seguretat) {
        this.codi_seguretat = codi_seguretat;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}
