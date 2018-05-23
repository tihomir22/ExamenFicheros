/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenficheros;

/**
 *
 * @author sportak
 */
abstract class Articulos {
    protected String id;
    protected String nombre;
    protected String precio;
    protected String categoria;

    public Articulos(String id, String nombre, String precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    abstract String formatear();
    abstract double calcularNumCajas();

    @Override
    public String toString() {
        return this.id+"\t"+this.nombre+"\t"+this.precio+"\t"+this.categoria;
    }
    
}
