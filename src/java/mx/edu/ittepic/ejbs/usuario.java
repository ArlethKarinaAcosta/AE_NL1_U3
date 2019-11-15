/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 *
 * @author arlet
 */
@Stateful
@Remote (usuarioRemote.class)
public class usuario implements usuarioRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
