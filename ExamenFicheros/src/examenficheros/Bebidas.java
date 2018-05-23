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
public class Bebidas extends Articulos {

    private String litros;

    public Bebidas(String litros, String id, String nombre, String precio, String categoria) {
        super(id, nombre, precio, categoria);
        this.litros = litros;
    }

    public String getLitros() {
        return litros;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.litros;
    }

    @Override
    String formatear() {
        return this.id + ";" + this.nombre + ";" + this.precio + ";" + this.categoria + ";" + this.litros + ";";
    }

    @Override
    double calcularNumCajas() {
        double litros = Double.parseDouble(this.litros);
        litros = litros / 10;
        return litros;

    }

}
