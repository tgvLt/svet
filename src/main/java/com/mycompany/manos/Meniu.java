/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 *
 * @author mantas.pipine
 */
public class Meniu extends Panel {

    public Meniu() {
        setStyleName("meniuFixed");
        Label pirmas = new Label("Pirmas");
        Label antras = new Label("Antras");
        Label trecias = new Label("Trecias");
        Label ketvirtas = new Label("Ketvirtas");

        pirmas.setWidth("100px");
        antras.setWidth("100px");
        trecias.setWidth("100px");
        ketvirtas.setWidth("100px");

        pirmas.setStyleName("meniuLabel");
        antras.setStyleName("meniuLabel");
        trecias.setStyleName("meniuLabel");
        ketvirtas.setStyleName("meniuLabel");

        HorizontalLayout hori = new HorizontalLayout(pirmas, antras, trecias, ketvirtas);
        hori.setSpacing(true);
        hori.setComponentAlignment(pirmas, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(antras, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(trecias, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(ketvirtas, Alignment.MIDDLE_CENTER);
        hori.setWidth("100%");

        setContent(hori);
    }

}
