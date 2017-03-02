/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 *
 * @author mantas.pipine
 */
public class Meniu extends Panel {

    private HorizontalLayout hori;
    private Boolean fullMenu = true;

    public Meniu() {

        setStyleName("meniuFixed");

        Responsive.makeResponsive(this);

        Label pirmas = new Label("Pirmas");
        Label antras = new Label("Antras");
        Label trecias = new Label("Trecias");
        Label ketvirtas = new Label("Ketvirtas");
        Label penktas = new Label("Penktas");

        pirmas.setWidth("100px");
        antras.setWidth("100px");
        trecias.setWidth("100px");
        ketvirtas.setWidth("100px");
        penktas.setWidth("100px");

        pirmas.setStyleName("meniuLabel");
        antras.setStyleName("meniuLabel");
        trecias.setStyleName("meniuLabel");
        ketvirtas.setStyleName("meniuLabel");
        penktas.setStyleName("meniuLabel");

        if (Page.getCurrent().getBrowserWindowWidth() > 800) {
            hori = new HorizontalLayout(pirmas, antras, trecias, ketvirtas);
            hori.setComponentAlignment(pirmas, Alignment.MIDDLE_CENTER);
            hori.setComponentAlignment(antras, Alignment.MIDDLE_CENTER);
            hori.setComponentAlignment(trecias, Alignment.MIDDLE_CENTER);
            hori.setComponentAlignment(ketvirtas, Alignment.MIDDLE_CENTER);
            fullMenu = true;
        } else {
            hori = new HorizontalLayout(penktas);
            hori.setComponentAlignment(penktas, Alignment.MIDDLE_LEFT);
            hori.setComponentAlignment(penktas, Alignment.MIDDLE_CENTER);
            fullMenu = false;
        }

        hori.setSpacing(true);
        hori.setWidth("100%");

        Page.getCurrent().addBrowserWindowResizeListener(new Page.BrowserWindowResizeListener() {
            @Override
            public void browserWindowResized(Page.BrowserWindowResizeEvent event) {
                if (event.getWidth() > 800) {
                    if (!fullMenu) {
                        hori.removeComponent(penktas);
                        hori.addComponents(pirmas, antras, trecias, ketvirtas);
                        hori.setComponentAlignment(pirmas, Alignment.MIDDLE_CENTER);
                        hori.setComponentAlignment(antras, Alignment.MIDDLE_CENTER);
                        hori.setComponentAlignment(trecias, Alignment.MIDDLE_CENTER);
                        hori.setComponentAlignment(ketvirtas, Alignment.MIDDLE_CENTER);
                        fullMenu = true;
                    }
                } else if (fullMenu) {
                    hori.removeAllComponents();
                    hori.addComponent(penktas);
                    hori.setComponentAlignment(penktas, Alignment.MIDDLE_LEFT);
                    fullMenu = false;
                }
            }
        });

        setContent(hori);
    }

}
