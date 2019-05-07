/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Collection;

/**
 * 
 * @author Mark
 * 
 */
public interface Estado extends Comparable<Estado> { // parametro de entrada objeto do tipo estado 

	Collection<Estado> movimento();
	Estado getPai();

}