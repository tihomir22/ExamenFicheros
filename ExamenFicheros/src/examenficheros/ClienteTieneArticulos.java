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
public class ClienteTieneArticulos extends Exception {

    Clientes c;

    public ClienteTieneArticulos(Clientes c) {
        this.c = c;
    }

    public Clientes getC() {
        return c;
    }

    public void setC(Clientes c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "No puedes borrar " + c.toString() + " que tiene articulos!";
    }

}
