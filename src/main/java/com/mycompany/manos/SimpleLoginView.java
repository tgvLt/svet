/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manos;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static com.sun.org.apache.xml.internal.resolver.tools.ResolvingParser.validating;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import static com.vaadin.ui.DefaultFieldFactory.get;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import static java.lang.Math.round;
import static java.lang.ProcessBuilder.Redirect.from;
import static java.lang.ProcessBuilder.Redirect.to;
import static java.lang.String.format;
import static java.lang.System.in;
import static javafx.beans.binding.Bindings.and;
import static javafx.beans.binding.Bindings.or;
import javafx.beans.binding.When;
import static org.atmosphere.util.uri.UriComponent.valid;
import static sun.security.jgss.GSSUtil.login;
import static sun.security.krb5.internal.KDCOptions.with;

/**
 *
 * @author mantas.pipine
 */
public class SimpleLoginView extends CustomComponent implements View,
        Button.ClickListener {

    public static final String NAME = "login";

    private final TextField user;

    private final PasswordField password;

    private final Button loginButton;

    public SimpleLoginView() {
        setSizeFull();

        // Create the user input field
        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator(
                "Username must be an email address"));
        user.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");

        // Create login button
        loginButton = new Button("Login", this);

       // FixedMeniuPanel meniu = new FixedMeniuPanel();
        SlideMeniu slideMeniu = new SlideMeniu();
        MainPanel mainPanel = new MainPanel();
      
      Meniu meniu = new Meniu();
      

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(user, password, loginButton);
        fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        
        Label tarpas = new Label("");
        tarpas.setHeight("100px");
        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(meniu, slideMeniu, mainPanel, fields);
        viewLayout.setStyleName("layStyle");
        viewLayout.setHeightUndefined();
        
        

        //viewLayout.setWidth("100%");
        viewLayout.setSpacing(false);
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setComponentAlignment(meniu, Alignment.TOP_CENTER);
        viewLayout.setComponentAlignment(slideMeniu, Alignment.TOP_CENTER);
        viewLayout.setComponentAlignment(mainPanel, Alignment.TOP_CENTER);

        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);
        setHeightUndefined();
        
        
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // focus the username field when user arrives to the login view
        user.focus();
    }

    // Validator for validating the passwords
    private static final class PasswordValidator extends
            AbstractValidator<String> {

        public PasswordValidator() {
            super("The password provided is not valid");
        }

        @Override
        protected boolean isValidValue(String value) {
            //
            // Password must be at least 8 characters long and contain at least
            // one number
            //
            if (value != null
                    && (value.length() < 8 || !value.matches(".*\\d.*"))) {
                return false;
            }
            return true;
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {

        //
        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        if (!user.isValid() || !password.isValid()) {
            return;
        }

        String username = user.getValue();
        String password = this.password.getValue();

        //
        // Validate username and password with database here. For examples sake
        // I use a dummy username and password.
        //
        boolean isValid = username.equals("test@test.com")
                && password.equals("passw0rd");

        if (isValid) {

            // Store the current user in the service session
            getSession().setAttribute("user", username);

            // Navigate to main view
            getUI().getNavigator().navigateTo(SimpleLoginMainView.NAME);//

        } else {

            // Wrong password clear the password field and refocuses it
            this.password.setValue(null);
            this.password.focus();

        }
    }
}
