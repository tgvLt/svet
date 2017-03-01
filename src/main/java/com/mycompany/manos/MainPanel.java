/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.server.Responsive;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;

/**
 *
 * @author mantas.pipine
 */
public class MainPanel extends Panel {

    private Label tekstas;

    public MainPanel() {
        setStyleName("mainPanel");

        CssLayout layout = new CssLayout();
        layout.setWidth("100%");
        // layout.addStyleName("flexwrap");

// Enable Responsive CSS selectors for the layout
        Responsive.makeResponsive(layout);

        tekstas = new Label("This is a "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "long description of the image shown "
                + "on the right or below, depending on the "
                + "screen width. The text here could continue long.");

        //description.setSizeUndefined();
        layout.addComponent(tekstas);

        Panel panel1 = new Panel("oooo");
        Panel panel2 = new Panel("iiiii");
        layout.addComponent(panel1);
        layout.addComponent(panel2);
        
        Label test = new Label("Bandom mirkset");
        //test.setStyleName("test");
           layout.addComponent(test);
        
        panel1.setWidth("300px");
        panel2.setWidth("300px");
        

        setContent(layout);

    }

}
