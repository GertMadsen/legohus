/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command subclass used to forward the
 * customer to the input page for house dimensions
 * when 'New House' button is pressed in top menu.
 * 
 * @author Gert Lehmann Madsen
 */
public class House extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/inputpage";
    }

}