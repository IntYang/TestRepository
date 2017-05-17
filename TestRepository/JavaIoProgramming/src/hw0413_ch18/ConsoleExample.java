/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw0413_ch18;

import java.io.IOException;
import java.io.InputStream;

public class ConsoleExample{
public static void main(String[] args) throws IOException{
    InputStream is = System.in;
    
    //how1
    byte[] data = new byte[10];
    int dataByte = is.read(data);
    String str = new String(data, 0, dataByte-2);
    System.out.println(str);
    
    is.close();
    
    
    
    
}
}