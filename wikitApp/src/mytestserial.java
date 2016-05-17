/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author honli
 * 
 * add dll file into jdk/bin
 * 
 */
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.*;
import javax.comm.*;

public class mytestserial {

    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString = "Hello, world!\n";
    static SerialPort serialPort;
    static OutputStream outputStream;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //System.out.print(System.getProperty("java.library.path"));
        portList = CommPortIdentifier.getPortIdentifiers();        

        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                // if (portId.getName().equals("COM1")) {
                System.out.println(portId.getName());
                if (portId.getName().equals("COM9")) {
                    try {
                        serialPort = (SerialPort) portId.open("SimpleWriteApp", 2000);
                    } catch (PortInUseException e) {
                    }
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException e) {
                    }
                    try {
                        serialPort.setSerialPortParams(9600,
                                SerialPort.DATABITS_8,
                                SerialPort.STOPBITS_1,
                                SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException e) {
                    }
                    try {
                        for (int i = 0; i < 100; i++) {
                            outputStream.write(messageString.getBytes());
                            Thread.sleep(1000);
                        }
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

}
