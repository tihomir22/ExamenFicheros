/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class ExamenFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivoCSV = new File("datos.txt");
        File rutaInicial = new File("registro");
        Iterator<Clientes> it = null;
        String entrada, id, nombre, precio, categoria, embalaje, kg, litros;
        Clientes cactivo = null;
        Articulos aactivo = null;
        Aperitivos aper1;
        Bebidas beb1;
        Varios var1;
        ArrayList<File> directorios = new ArrayList<>();
        GESTIONARTICULOS ga = new GESTIONARTICULOS(archivoCSV, rutaInicial);
        int opcion = 999;
        Scanner teclado = new Scanner(System.in);
        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        it = ga.deCsvALista();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 2:

                    while (it.hasNext()) {
                        cactivo = it.next();
                        System.out.println(cactivo.toString());
                        cactivo.imprimirArticulosCliente();

                    }
                    break;

                case 3: {
                    try {
                        ga.deListaACarpeta();
                    } catch (IOException ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 4:
                    String rutaInicialS = ga.getCarpetaInicial().getName();
                    directorios = ga.recogerContenidoYGuardarEnArray(rutaInicialS);

                    break;
                case 5:
                    System.out.println("Elija un cliente,introduzca su dni");
                    ga.imprimirClientes();
                    teclado.nextLine();

                    entrada = teclado.nextLine();
                     {
                        try {
                            cactivo = ga.buscarClientes(entrada);
                        } catch (ClienteNoExisteExcepcion ex) {
                            Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                     {
                        try {
                            if (ga.buscarClientes(entrada) != null) {
                                System.out.println("Encontrado");
                                System.out.println("Que tipo de producto quieres añadir? [1]Aperitivos [2]Varios [3]Bebidas ");
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("Introduzca id del producto");
                                        id = teclado.nextLine();
                                        System.out.println("Introduzca nombre del producto");
                                        nombre = teclado.nextLine();
                                        System.out.println("Introduzca precio del producto");
                                        precio = teclado.nextLine();
                                        System.out.println("Introduzca categoria del producto");
                                        categoria = teclado.nextLine();
                                        System.out.println("Introduzca embalaje,bolsa,lata o break");
                                        embalaje = teclado.nextLine();
                                        if (embalaje.equalsIgnoreCase("bolsa")) {
                                            aper1 = new Aperitivos(Embalaje.BOLSA, id, nombre, precio, categoria);
                                            cactivo.añadirArticulo(aper1);
                                        } else if (embalaje.equalsIgnoreCase("break")) {
                                            aper1 = new Aperitivos(Embalaje.BREAK, id, nombre, precio, categoria);
                                            cactivo.añadirArticulo(aper1);
                                        } else if (embalaje.equalsIgnoreCase("lata")) {
                                            aper1 = new Aperitivos(Embalaje.LATA, id, nombre, precio, categoria);
                                            cactivo.añadirArticulo(aper1);
                                        } else {
                                            System.out.println("Introduciste algun embalaje incorrecto... :((");
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Introduzca id del producto");
                                        id = teclado.nextLine();
                                        System.out.println("Introduzca nombre del producto");
                                        nombre = teclado.nextLine();
                                        System.out.println("Introduzca precio del producto");
                                        precio = teclado.nextLine();
                                        System.out.println("Introduzca categoria del producto");
                                        categoria = teclado.nextLine();
                                        System.out.println("Introduzca kilos");
                                        kg = teclado.nextLine();
                                        var1 = new Varios(kg, id, nombre, precio, categoria);
                                        cactivo.añadirArticulo(var1);
                                        break;

                                    case 3:
                                        System.out.println("Introduzca id del producto");
                                        id = teclado.nextLine();
                                        System.out.println("Introduzca nombre del producto");
                                        nombre = teclado.nextLine();
                                        System.out.println("Introduzca precio del producto");
                                        precio = teclado.nextLine();
                                        System.out.println("Introduzca categoria del producto");
                                        categoria = teclado.nextLine();
                                        System.out.println("Introduzca litros");
                                        litros = teclado.nextLine();
                                        beb1 = new Bebidas(litros, id, nombre, precio, categoria);
                                        cactivo.añadirArticulo(beb1);
                                        break;
                                }
                            }
                            cactivo.imprimirArticulosCliente();
                        } catch (ClienteNoExisteExcepcion ex) {
                            System.out.println(ex.toString());
                        }
                    }
                    break;
                case 6: {
                    try {
                        ga.deListaACarpeta();
                    } catch (IOException ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 7:
                    System.out.println("Elija un cliente,introduzca su dni");
                    ga.imprimirClientes();
                    teclado.nextLine();
                    entrada = teclado.nextLine();

                    try {
                        cactivo = ga.buscarClientes(entrada);
                        if (cactivo != null) {
                            System.out.println("Que articulo quieres calcularle las cajas?");
                            cactivo.imprimirArticulosCliente();
                            entrada = teclado.nextLine();
                            Articulos art = cactivo.buscarArticulo(entrada);
                            System.out.println(art.calcularNumCajas());
                        }
                    } catch (ClienteNoExisteExcepcion ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 8:
                    System.out.println("Elija un cliente,introduzca su dni");
                    ga.imprimirClientes();
                    teclado.nextLine();
                    entrada = teclado.nextLine();

                    try {
                        cactivo = ga.buscarClientes(entrada);
                        if (cactivo != null) {
                            ga.borrarCliente(cactivo, rutaInicial.getName());
                        } else {
                            System.out.println("No existe el cliente");
                        }
                    } catch (ClienteNoExisteExcepcion ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClienteTieneArticulos ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 9:
                    System.out.println("Elija un cliente,introduzca su dni");
                    ga.imprimirClientes();
                    teclado.nextLine();
                    entrada = teclado.nextLine();
                    try {
                        cactivo = ga.buscarClientes(entrada);
                        if (cactivo != null) {
                            System.out.println("Seleccione un articulo por su codigo");
                            cactivo.imprimirArticulosCliente();
                            entrada = teclado.nextLine();
                            aactivo = cactivo.buscarArticulo(entrada);
                            if (aactivo != null) {
                                System.out.println("Cual será el nuevo codigo del articulo?");
                                aactivo.setId(teclado.nextLine());
                                ga.deListaACarpeta();
                            } else {
                                System.out.println("No existe el articulo introducido ");
                            }
                        } else {
                            System.out.println("No existe tal cliente");
                        }
                    } catch (ClienteNoExisteExcepcion ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ExamenFicheros.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 10:
                    ArrayList<String> listaFicheros = new ArrayList<>();
                    ga.deCarpetaACSV(rutaInicial.getName(), listaFicheros);
                    break;
            }
        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("1.-Cargar los usuarios desde el archivo CSV");
        System.out.println("2.-Visualizar los proveedores con sus productos");
        System.out.println("3.-Generar la estructura en disco");
        System.out.println("4.-Imprimir estructura en disco");
        System.out.println("5.-Dar de alta un producto para un cliente");
        System.out.println("6.-Para el articulo generado se debera generar un archivo con sus datos");
        System.out.println("7.-Calcular cajas para un producto en concreto");
        System.out.println("8.-Borrar un cliente");
        System.out.println("9.-Modificar un articulo tanto en lista como archivos");
        System.out.println("10.-Crea a partir de la estructura de carpetas");
    }

}
