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
public class Varios extends Articulos {

    private String kilos;

    public Varios(String kilos, String id, String nombre, String precio, String categoria) {
        super(id, nombre, precio, categoria);
        this.kilos = kilos;
    }

    public String getKilos() {
        return kilos;
    }

    public void setKilos(String kilos) {
        this.kilos = kilos;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.kilos;
    }

    @Override
    String formatear() {
        return this.id + ";" + this.nombre + ";" + this.precio + ";" + this.categoria + ";" + this.kilos + ";";
    }

    @Override
    double calcularNumCajas() {
        double cantidad;
        cantidad = Double.parseDouble(this.kilos) / 20;
        return cantidad;
    }

}
