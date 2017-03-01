/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Panel;

/**
 *
 * @author mantas.pipine
 */
public class NewMeniu extends Panel{

    public NewMeniu() {
            setStyleName("cssmenu");
        CustomLayout cs = new CustomLayout("fixedMeniu");
        
        setContent(cs);
    }
    
    
    
}
