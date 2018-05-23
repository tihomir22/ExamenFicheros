/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenficheros;

import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Clientes {

    private String id;
    private String nombre;
    private ArrayList<Articulos> listaArticulos = new ArrayList<>();

    public Clientes(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Articulos> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public void añadirArticulo(Articulos a) {
        if (this.buscarArticulo(a.getId()) == null) {
            this.listaArticulos.add(a);
        } else {
            System.out.println("El cliente ya tiene ese articulo en concreto");
        }
    }

    public Articulos buscarArticulo(String a) {
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            if (a.equalsIgnoreCase(this.listaArticulos.get(i).getId())) {
                return this.listaArticulos.get(i);
            }
        }
        return null;
    }

    public void imprimirArticulosCliente() {
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            System.out.println(this.listaArticulos.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.nombre + "\t";
    }

}
