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
public class Aperitivos extends Articulos {

    private Embalaje embalaje;

    public Aperitivos(Embalaje embalaje, String id, String nombre, String precio, String categoria) {
        super(id, nombre, precio, categoria);
        this.embalaje = embalaje;
    }

    public Embalaje getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Embalaje embalaje) {
        this.embalaje = embalaje;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.embalaje;
    }

    @Override
    String formatear() {
        return this.id + ";" + this.nombre + ";" + this.precio + ";" + this.categoria + ";" + this.embalaje + ";";
    }

    @Override
    double calcularNumCajas() {
        double cantidad = 0;
        if (this.embalaje.toString().equalsIgnoreCase("bolsa")) {
            cantidad = 1 / 50;

        } else if (this.embalaje.toString().equalsIgnoreCase("lata")) {
            cantidad = 1 / 100;

        } else if (this.embalaje.toString().equalsIgnoreCase("break")) {
            cantidad = 1 / 25;

        }
        return cantidad;
    }

}
