/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.Scanner;
import java.net.*;
import java.io.*;
import Cliente.Persona;
import java.text.ParseException;


public class Cliente {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        String nombre = sc.nextLine();
        String apellido = sc.nextLine();
        String fecha = sc.nextLine();
        
        Persona persona1 = new Persona(nombre, apellido, fecha);
       
      
        
        System.out.println(persona1.MsjCli());
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        
        byte[] mensaje_bytes = new byte[256];
        
        try {
            socket = new Socket("localhost",5500);
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(persona1.MsjSer());
            

            out.close();
            socket.close();
         }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
         }
        
    }
}
