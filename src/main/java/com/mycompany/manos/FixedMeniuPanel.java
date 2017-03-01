/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author mantas.pipine
 */
public class FixedMeniuPanel extends Panel {
    
    public FixedMeniuPanel() {
        setStyleName("meniuPanel");
        
        Meniu men =  new Meniu();
        VerticalLayout hs = new VerticalLayout(men);
        hs.setComponentAlignment(men, Alignment.TOP_CENTER);
       // hs.setWidth("100%");
       
        
        setContent(hs);
        
    }
    
}
