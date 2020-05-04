package com.ipiecoles.java.java240;

public class Produit {

    private String intitule;

    private Double prixEuro;

    public Produit(String intitule, Double prixEuro) {
        this.intitule = intitule;
        this.prixEuro = prixEuro;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getPrixEuro() {
        return prixEuro;
    }

    public void setPrixEuro(Double prixEuro) {
        this.prixEuro = prixEuro;
    }

    @Override
    public String toString() {
        return "Produit : " +
                "'" + intitule + '\'' +
                ", prix : " + prixEuro +
                '€';
    }
}
