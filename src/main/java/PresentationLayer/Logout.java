/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.LogoutException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
public class Logout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LogoutException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        throw new LogoutException("");
    }

}