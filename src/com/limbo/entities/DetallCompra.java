package com.limbo.entities;

public class DetallCompra {
    int compra_id, producte_id;
    double pvp, pes;
    String unitats_producte;

    public int getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(int compra_id) {
        this.compra_id = compra_id;
    }

    public int getProducte_id() {
        return producte_id;
    }

    public void setProducte_id(int producte_id) {
        this.producte_id = producte_id;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public Double getPes() {
        return pes;
    }

    public void setPes(Double pes) {
        this.pes = pes;
    }

    public String getUnitats_producte() {
        return unitats_producte;
    }

    public void setUnitats_producte(String unitats_producte) {
        this.unitats_producte = unitats_producte;
    }
}
