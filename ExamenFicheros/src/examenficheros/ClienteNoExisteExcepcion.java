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
public class ClienteNoExisteExcepcion extends Exception {
    String str;

    public ClienteNoExisteExcepcion(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "El cliente con el numero de dni "+this.str+" no existe!";
    }
    
    
}
