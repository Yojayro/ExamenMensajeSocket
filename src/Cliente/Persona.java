/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    private String nombre;
    private String apellido;
    private String fechaN;

    public Persona(String nombre, String apellido, String fechaN) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fechaN;
    }

    public void setFecha(String fecha) {
        this.fechaN = fecha;
    }
    
      public String edad() throws ParseException{
        
        String date = this.getFecha();
 
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(date, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        
        int año = periodo.getYears();
        String edad = Integer.toString(año);
        return edad;
    }

    public String MsjCli() throws ParseException{
        String name = this.getNombre();
        String lastname = this.getApellido();
        String date = this.getFecha();
        
       
        String Mensaje = name + " | " + lastname + " | " + date;
        return Mensaje;
    }
      
    public String MsjSer() throws ParseException{
        String nombre = this.getNombre();
        String apellido = this.getApellido();
        String edad = this.edad();
       String Mensaje = " El cliente "+ nombre +" " + apellido + " con edad de " + edad + " años";
        return Mensaje;
    }
}
