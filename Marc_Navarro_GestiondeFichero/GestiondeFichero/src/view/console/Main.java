package view.console;

import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Funciones;



public class Main {
    static Scanner mec = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;

        do {
            
            System.out.println("MENU:");
            System.out.println("1.- CreateFolder");
            System.out.println("2.- CreateFile");
            System.out.println("3.- ShowListFiles");
            System.out.println("4.- ShowFiles");
            System.out.println("5.- overWrite");
            System.out.println("6.- deleteFiles");
            System.out.println("7.- countChars");
            System.out.println("8.- countWords");
            System.out.println("9.- SwapWords");
            System.out.println("10.- PrintPDF");
            System.out.println("z.- Salir");
            System.out.print("Opcion: ");
           
            opcion = mec.next();
            
            switch (opcion) {
                case "1":
    System.out.print("Introduce el nombre de la carpeta: ");
    mec.nextLine(); 
    String FolderName = mec.nextLine(); 
    Funciones.createFolder(FolderName);  
                    break;
                case "2":
                    mec.nextLine(); 
    System.out.print("Introduce la ruta donde guardar el archivo: ");
    String path2 = mec.nextLine();

    System.out.print("Introduce el nombre del archivo: ");
    String fileName2 = mec.nextLine();

    System.out.print("Introduce el contenido del archivo: ");
    String content2 = mec.nextLine();

    Funciones.createFile(path2, fileName2, content2);
                    
                    break;
                case "3":
                    mec.nextLine(); 
    System.out.print("Introduce la ruta de la carpeta: ");
    String rutaCarpeta = mec.nextLine();
    String[] archivos = Funciones.showListFiles(rutaCarpeta);
    for (String archivo : archivos) {
        System.out.println(archivo);
    }
                    break;
                case "4":
                    mec.nextLine();
    System.out.print("Introduce la ruta del archivo: ");
    String rutaVer = mec.nextLine();
    System.out.print("Introduce el nombre del archivo: ");
    String archivoVer = mec.nextLine();

    String contenido = Funciones.showFile(rutaVer, archivoVer);
    if (contenido != null) {
        System.out.println("Contenido del archivo:");
        System.out.println(contenido);
    }
                    break;
                case "5":
                   mec.nextLine(); 
    System.out.print("Introduce la ruta del archivo: ");
    String rutaOver = mec.nextLine();

    System.out.print("Introduce el nombre del archivo: ");
    String nombreOver = mec.nextLine();

    System.out.print("Introduce el nuevo contenido: ");
    String nuevoContenido = mec.nextLine();

    boolean exito = Funciones.overWriteFile(rutaOver, nombreOver, nuevoContenido);
    if (!exito) {
        System.out.println("No se pudo sobrescribir el archivo.");
    }
                 break;
                    
                case "6":
                     mec.nextLine(); 
    System.out.print("Introduce la ruta del archivo a eliminar: ");
    String rutaEliminar = mec.nextLine();

    System.out.print("Introduce el nombre del archivo a eliminar: ");
    String nombreEliminar = mec.nextLine();

    Funciones.deleteFile(rutaEliminar, nombreEliminar);
                    
                    break;
                case "7":
                    
                   mec.nextLine(); 
    System.out.print("Introduce la ruta del archivo: ");
    String rutaContar = mec.nextLine();

    System.out.print("Introduce el nombre del archivo: ");
    String nombreContar = mec.nextLine();

    int numCaracteres = Funciones.countChars(rutaContar, nombreContar);
    if (numCaracteres >= 0) {
        System.out.println("Número de caracteres: " + numCaracteres);
    } else {
        System.out.println("No se pudo contar los caracteres.");
    }
                    break;
                case "8":
                 mec.nextLine(); 
    System.out.print("Introduce la ruta del archivo: ");
    String rutaPalabras = mec.nextLine();

    System.out.print("Introduce el nombre del archivo: ");
    String nombrePalabras = mec.nextLine();

    int cantidadPalabras = Funciones.countWords(rutaPalabras, nombrePalabras);
    if (cantidadPalabras >= 0) {
        System.out.println("Número de palabras: " + cantidadPalabras);
    } else {
        System.out.println("No se pudo contar las palabras.");
    }
                case "9":
                    
                mec.nextLine();
    System.out.print("Introduce la ruta del archivo: ");
    String rutaSwap = mec.nextLine();

    System.out.print("Introduce el nombre del archivo: ");
    String nombreSwap = mec.nextLine();

    System.out.print("Palabra a reemplazar: ");
    String OldWord = mec.nextLine();

    System.out.print("Nueva palabra: ");
    String NewWord = mec.nextLine();

    String resultado = Funciones.swapWords(rutaSwap, nombreSwap, OldWord, NewWord);
    if (resultado != null) {
        System.out.println("Contenido actualizado:\n" + resultado);
    } else {
        System.out.println("No se pudo modificar el archivo.");
    }
            
                    break;


                case "10":
                   mec.nextLine();
    System.out.print("Introduce la ruta del archivo: ");
    String rutaPDF = mec.nextLine();
    System.out.print("Introduce el nombre del archivo: ");
    String archivoPDF = mec.nextLine();

    Funciones.printPDF(rutaPDF, archivoPDF);
                    break;
                case "z":
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }
        } while (!"z".equals(opcion));
    }
}

    


