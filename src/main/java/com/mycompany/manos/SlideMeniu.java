/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

/**
 *
 * @author mantas.pipine
 */
public class SlideMeniu extends Panel {

    private String styleName = "slideMeniuPanel";
    private CustomLayout layout;
    private Panel vi;
    private Panel vi1;

    public SlideMeniu() {

        setStyleName("slideMeniuPanel");
        // setStyleName("image-head");
        
       // setHeight("800px");

        layout = new CustomLayout("mylayout");
        layout.setSizeUndefined();
      //  layout.setStyleName("mySlides");

        Page.getCurrent().getJavaScript().execute("var slideIndex = 1;\n"
                + "showSlides(slideIndex);\n"
                + "\n"
                + "function plusSlides(n) {\n"
                + "  showSlides(slideIndex += n);\n"
                + "}\n"
                + "\n"
                + "function currentSlide(n) {\n"
                + "  showSlides(slideIndex = n);\n"
                + "}\n"
                + "\n"
                + "function showSlides(n) {\n"
                + "  var i;\n"
                + "  var slides = document.getElementsByClassName(\"mySlides\");\n"
                + "  var dots = document.getElementsByClassName(\"dot\");\n"
                + "  if (n > slides.length) {slideIndex = 1} \n"
                + "  if (n < 1) {slideIndex = slides.length}\n"
                + "  for (i = 0; i < slides.length; i++) {\n"
                + "      slides[i].style.display = \"none\"; \n"
                + "  }\n"
                + "  for (i = 0; i < dots.length; i++) {\n"
                + "      dots[i].className = dots[i].className.replace(\" active\", \"\");\n"
                + "  }\n"
                + "  slides[slideIndex-1].style.display = \"block\"; \n"
                + "  dots[slideIndex-1].className += \" active\";\n"
                + "}");

        // layout.addStyleName("flexwrap");
        // Enable Responsive CSS selectors for the layout
        Responsive.makeResponsive(layout);

//        String basepath = VaadinService.getCurrent()
//                .getBaseDirectory().getAbsolutePath();
//
//        FileResource pirmasResource = new FileResource(new File(basepath + "/WEB-INF/images/mountain.jpg"));
//        FileResource pirmas1Resource = new FileResource(new File(basepath + "/WEB-INF/images/road.jpg"));
//        Image img1 = new Image(null, pirmasResource);
//        Image img2 = new Image(null, pirmas1Resource);
        setContent(layout);
    }

}
