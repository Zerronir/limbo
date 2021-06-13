package com.limbo.entities;

public class LineaCistella {
    Producte producte;
    int quantitat;
    long preu;

    public Producte getProducte() {
        return producte;
    }

    public void setProducte(Producte producte) {
        this.producte = producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public long getPreu() {
        return preu;
    }

    public void setPreu(long preu) {
        this.preu = preu;
    }
}
