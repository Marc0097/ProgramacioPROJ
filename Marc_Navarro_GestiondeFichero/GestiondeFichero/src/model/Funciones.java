/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.text.Document;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph; //dona error nose si es per la versio o algo
import com.itextpdf.text.pdf.PdfWriter;



/**
 *
 * @author marcn
 */
public class Funciones {
 public static void createFolder(String fileName) {
        
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = path + separador + fileName;
        File Folder = new File(rutaCarpeta);
       
        if (!Folder.exists()) {
            Folder.mkdir();
        } else {
            System.out.println("No se pudo crear la carpeta");
        }
    } 
        
        
        
        
    
    public static boolean overWriteFile(String path, String fileName, String newContent) {
         String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("El archivo no existe.");
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(newContent);
            System.out.println("Archivo sobrescrito");
            return true;
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo: " + e.getMessage());
            return false;
        }
         
        
    }

    public static int countChars(String path, String fileName) {
         String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (file.exists() && file.isFile()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(fullPath)));
                return content.length();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("El archivo no existe o la ruta no es válida");
            return -1;
        }
    }

    public static void deleteFile(String path, String fileName) {
        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (file.exists() && file.isFile()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Archivo eliminado correctamente: " + fileName);
            } else {
                System.out.println("No se pudo eliminar el archivo");
            }
        } else {
            System.out.println("El archivo no existe o no es válido");
        }
    }

   

    public static void createFile(String path, String fileName, String content) {
        String rutaCarpeta = path + File.separator + fileName;
         File file = new File(rutaCarpeta);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine(); 
            System.out.println("Contenido escrito en el archivo: " + rutaCarpeta);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } 
    }

    public static String [] showListFiles(String path) {
         File carpeta = new File(path);

        if (carpeta.exists() && carpeta.isDirectory()) {
            String[] listFiles = carpeta.list();
            if (listFiles != null && listFiles.length > 0) {
                return listFiles;
            } else {
                System.out.println("La carpeta esta vacía.");
                return new String[0];
            }
        } else {
            System.out.println("La ruta no existe");
            return new String[0];
        }
    }

    public static String showFile(String path, String fileName) {
    String fullPath = path + File.separator + fileName;
    File file = new File(fullPath);

    if (file.exists() && file.isFile()) {
        try {
            return new String(Files.readAllBytes(Paths.get(fullPath)));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    } else {
        System.out.println("El archivo no existe o no es válido.");
        return null;
    }
    }
 
    public static int countWords(String path, String fileName) {
       
        String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (file.exists() && file.isFile()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(fullPath)));
                if (content.trim().isEmpty()) {
                    return 0;
                }
                String[] words = content.trim().split("\\s+");
                return words.length;
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("El archivo no existe o la ruta no es válida.");
            return -1;
        }
}
    public static String  swapWords(String path, String fileName, String oldWord, String newWord) {
       String fullPath = path + File.separator + fileName;
        File file = new File(fullPath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("El archivo no existe o no es válido.");
            return null;
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get(fullPath)));

          
            String replacedContent = content.replaceAll("\\b" + oldWord + "\\b", newWord);

           
            Files.write(Paths.get(fullPath), replacedContent.getBytes());

            return replacedContent;
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return null;
        }
}
    public static void printPDF(String path, String fileName) {
    String fullPath = path + File.separator + fileName;
    File file = new File(fullPath);

    if (!file.exists() || !file.isFile()) {
        System.out.println("El archivo no existe o no es válido.");
        return;
    }

    try {
        String content = new String(Files.readAllBytes(Paths.get(fullPath)));

        Document document = new Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(fullPath.replace(".txt", ".pdf")));
        document.open();
        document.add(new Paragraph(content));
        document.close();

    } catch (Exception e) {
        System.out.println("Error al generar PDF: " + e.getMessage());
    }
}
//em dona error la libreria 
    
}
