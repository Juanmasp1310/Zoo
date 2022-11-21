/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 *
 * @author Juanma
 */
public class metodos {
    
    //Método para encriptar las contraseñas con MD5
    public static String passMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    //Método para validar el teléfono móvil
    public static boolean validarMovil(String movil) {
    Pattern p = Pattern.compile("^\\d{9}$");
    return p.matcher(movil).matches();
    }
    
    //Método para pasarle los datos de una persona y que devuelva la consulta SQL necesario para insertarlos
    public static String insertarPersonas(String usuario, int tlf, float salario, String nombre, String apellidos, String cargo, String password){
        
        String sql = "INSERT INTO personas VALUES(null,'"+usuario+"',"+tlf+","+salario+",'"+nombre+"','"+apellidos+"','"+cargo+"',"+"'','"+password+"',current_timestamp())";        
        return sql;
    }
    
    
    
    //Método para pasarle los datos de un cuidador y que devuelva la consulta SQL necesario para insertarlos
    public static String insertarCuidador(String usuario, int tlf, float salario, String nombre, String apellidos, String cargo, String especialidad, String password){
        
        String sql = "INSERT INTO personas VALUES(null,'"+usuario+"',"+tlf+","+salario+",'"+nombre+"','"+apellidos+"','"+cargo+"','"+especialidad+"','"+password+"',current_timestamp())";        
        return sql;
    }
    
    //Método para comprobar que la cadena de caracteres son solo números
    public static boolean isNumeric(String s){
        
        if (s == null || s.equals("")) {
            return false;
        }
 
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
        
    }
    
}
