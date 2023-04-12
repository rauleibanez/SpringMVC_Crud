/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author RAUL IBANEZ
 */
public class usuarioValidar implements Validator {
    
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> type) {
        return Usuarios.class.isAssignableFrom(type);
        //return Tuclase.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuarios usuario = (Usuarios)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomusr", "required.nomusr", "El Campo nombre es OBLIGATORIO!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailusr", "required.emailusr", "El Campo correo es OBLIGATORIO!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telusr", "required.telusr", "El Campo telefono es OBLIGATORIO!");
      
    // VALIDACION DEL FORMATO DEL CORREO
    if (!(usuario.getEmailusr() != null && usuario.getEmailusr().isEmpty())){
        // Patrón para validar el email
        this.pattern = Pattern.compile(EMAIL_PATTERN);
        this.matcher = pattern.matcher(usuario.getEmailusr());
        if (!matcher.matches()){
            errors.rejectValue("correo", "correo.incorrect","El Correo " + usuario.getEmailusr() + " es INCORRECTO! ");
        }
        System.out.println("El email ingresado es inválido.");
        
    } else {
        System.out.println("El email ingresado es válido.");
    }
    }
}