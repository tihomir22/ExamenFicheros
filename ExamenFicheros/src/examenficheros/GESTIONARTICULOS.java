/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class GESTIONARTICULOS {

    private File archivoCSV;
    private File carpetaInicial;
    private ArrayList<Clientes> listaClientesCLASS = new ArrayList<>();

    public ArrayList<Clientes> getListaClientesCLASS() {
        return listaClientesCLASS;
    }

    public void setListaClientesCLASS(ArrayList<Clientes> listaClientesCLASS) {
        this.listaClientesCLASS = listaClientesCLASS;
    }

    public GESTIONARTICULOS(File archivoCSV, File carpetaInicial) {
        this.archivoCSV = archivoCSV;
        this.carpetaInicial = carpetaInicial;
    }

    public File getArchivoCSV() {
        return archivoCSV;
    }

    public void setArchivoCSV(File archivoCSV) {
        this.archivoCSV = archivoCSV;
    }

    public File getCarpetaInicial() {
        return carpetaInicial;
    }

    public void setCarpetaInicial(File carpetaInicial) {
        this.carpetaInicial = carpetaInicial;
    }

    public Iterator<Clientes> deCsvALista() throws FileNotFoundException {
        Scanner sc = new Scanner(this.archivoCSV);
        String linea, articulo = "";
        String[] contenidoLinea;
        String[] contenidoArticulo;
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Clientes cli1;
        Bebidas beb1;
        Aperitivos aper1 = null;
        Varios var1;
        while (sc.hasNext()) {

            linea = sc.nextLine();
            contenidoLinea = linea.split(";");
            if (contenidoLinea[1].equalsIgnoreCase("mercadona")) {
                contenidoLinea[0] = contenidoLinea[0].substring(1, contenidoLinea[0].length());
            }
            cli1 = new Clientes(contenidoLinea[0], contenidoLinea[1]);
            System.out.println(cli1.toString());
            int k = 0;
            for (int i = 2; i < contenidoLinea.length; i++) {
                articulo += contenidoLinea[i].trim() + ";"; // IMPORTANTANTISIMOOOO!!!!!!!!!
                k++;
                if (k == 5) {
                    contenidoArticulo = articulo.split(";");

                    //System.out.println(Arrays.toString(contenidoArticulo));
                    if (contenidoArticulo[3].equalsIgnoreCase("Aperitivo")) {

                        if (contenidoArticulo[4].equalsIgnoreCase("Bolsa")) {
                            aper1 = new Aperitivos(Embalaje.BOLSA, contenidoArticulo[0], contenidoArticulo[1], contenidoArticulo[2], contenidoArticulo[3]);

                        } else if (contenidoArticulo[4].equalsIgnoreCase("lata")) {
                            aper1 = new Aperitivos(Embalaje.LATA, contenidoArticulo[0], contenidoArticulo[1], contenidoArticulo[2], contenidoArticulo[3]);

                        } else if (contenidoArticulo[4].equalsIgnoreCase("break")) {
                            aper1 = new Aperitivos(Embalaje.BREAK, contenidoArticulo[0], contenidoArticulo[1], contenidoArticulo[2], contenidoArticulo[3]);

                        }
                        cli1.añadirArticulo(aper1);
                    }
                    if (contenidoArticulo[3].equalsIgnoreCase("varios")) {
                        var1 = new Varios(contenidoArticulo[4], contenidoArticulo[0], contenidoArticulo[1], contenidoArticulo[2], contenidoArticulo[3]);
                        cli1.añadirArticulo(var1);
                    }
                    if (contenidoArticulo[3].equalsIgnoreCase("bebida")) {
                        beb1 = new Bebidas(contenidoArticulo[4], contenidoArticulo[0], contenidoArticulo[1], contenidoArticulo[2], contenidoArticulo[3]);
                        cli1.añadirArticulo(beb1);
                    }

                    k = 0;
                    articulo = "";

                }

            }
            //cli1.imprimirArticulosCliente();
            listaClientes.add(cli1);
            this.listaClientesCLASS.add(cli1);
        }
        System.out.println("Carga exitosa,devolviendo lista de clientes");
        return listaClientes.iterator();
    }

    public void deListaACarpeta() throws IOException {

        if (this.listaClientesCLASS.isEmpty()) {
            System.out.println("Debes cargar antes el archivo csv al sistema!");
        } else {
            String hijos;
            Clientes activo;
            for (int i = 0; i < this.listaClientesCLASS.size(); i++) {
                activo = this.listaClientesCLASS.get(i);
                if (!this.carpetaInicial.exists()) {
                    this.carpetaInicial.mkdir();
                    hijos = this.carpetaInicial.getName() + "/" + activo.getNombre();
                    File archHijos = new File(hijos);
                    if (archHijos.exists()) {
                        for (int j = 0; j < activo.getListaArticulos().size(); j++) {
                            String archivo = archHijos.getAbsolutePath() + "/" + activo.getListaArticulos().get(j).getId() + ".dat";
                            File archivoHijo = new File(archivo);
                            archivoHijo.createNewFile();
                            PrintWriter pw = new PrintWriter(archivoHijo);
                            pw.println(activo.getListaArticulos().get(j).formatear());
                            pw.close();
                        }
                    } else {
                        archHijos.mkdir();
                        for (int j = 0; j < activo.getListaArticulos().size(); j++) {
                            String archivo = archHijos.getAbsolutePath() + "/" + activo.getListaArticulos().get(j).getId() + ".dat";
                            File archivoHijo = new File(archivo);
                            archivoHijo.createNewFile();
                            PrintWriter pw = new PrintWriter(archivoHijo);
                            pw.println(activo.getListaArticulos().get(j).formatear());
                            pw.close();
                        }
                    }
                } else {
                    hijos = this.carpetaInicial.getName() + "/" + activo.getNombre();
                    File archHijos = new File(hijos);
                    if (archHijos.exists()) {
                        for (int j = 0; j < activo.getListaArticulos().size(); j++) {
                            String archivo = archHijos.getAbsolutePath() + "/" + activo.getListaArticulos().get(j).getId() + ".dat";
                            File archivoHijo = new File(archivo);
                            archivoHijo.createNewFile();
                            PrintWriter pw = new PrintWriter(archivoHijo);
                            pw.println(activo.getListaArticulos().get(j).formatear());
                            pw.close();
                        }
                    } else {
                        archHijos.mkdir();
                        for (int j = 0; j < activo.getListaArticulos().size(); j++) {
                            String archivo = archHijos.getAbsolutePath() + "/" + activo.getListaArticulos().get(j).getId() + ".dat";
                            File archivoHijo = new File(archivo);
                            archivoHijo.createNewFile();
                            PrintWriter pw = new PrintWriter(archivoHijo);
                            pw.println(activo.getListaArticulos().get(j).formatear());
                            pw.close();
                        }
                    }
                }

            }
        }
    }

    public ArrayList<File> recogerContenidoYGuardarEnArray(String rutaInicial) {
        File rutaFich = new File(rutaInicial);
        ArrayList<File> listaUsuarios = new ArrayList<>();
        File[] listaFicheros = rutaFich.listFiles();
        for (int i = 0; i < listaFicheros.length; i++) {
            if (listaFicheros[i].isDirectory()) {
                System.out.println(listaFicheros[i].getName());
                listaUsuarios = recogerContenidoYGuardarEnArray(rutaInicial + "/" + listaFicheros[i].getName());
            }
            if (listaFicheros[i].isFile()) {
                System.out.println("\t" + listaFicheros[i].getName());
                listaUsuarios.add(listaFicheros[i]);
            }
        }

        return listaUsuarios;
    }

    public void imprimirClientes() {
        for (int i = 0; i < this.listaClientesCLASS.size(); i++) {
            System.out.println(this.listaClientesCLASS.get(i).toString());
        }
    }

    public Clientes buscarClientes(String dni) throws ClienteNoExisteExcepcion {
        for (int i = 0; i < this.listaClientesCLASS.size(); i++) {
            if (this.listaClientesCLASS.get(i).getId().equalsIgnoreCase(dni)) {
                return this.listaClientesCLASS.get(i);
            }
        }
        throw new ClienteNoExisteExcepcion(dni);

    }

    public void añadirArticulosACliente(Articulos a, Clientes c) {
        for (int i = 0; i < this.listaClientesCLASS.size(); i++) {
            if (this.listaClientesCLASS.get(i).getId().equalsIgnoreCase(c.getId())) {
                this.listaClientesCLASS.get(i).getListaArticulos().add(a);
            }
        }
        System.out.println("Añadido exitosamente");

    }

}
