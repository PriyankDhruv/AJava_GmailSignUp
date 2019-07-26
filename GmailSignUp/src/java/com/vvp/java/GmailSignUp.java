/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author PRIYANK DHRUV
 */
public class GmailSignUp extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            String Username = request.getParameter("username");
            for(int i=0; i<Username.length(); i++){
            
                int Unicode = Username.codePointAt(i);
                if(!((Unicode > 64 && Unicode <= 90) || (Unicode >= 97 && Unicode <= 122) || (Unicode == 95) || 
                     (Unicode >= 48 && Unicode <= 57))){
                     
                    out.print("Special Symbol is not Allowed in the Username.");
                    return;
                }   
            }    
             
            String Email = request.getParameter("email");
            int firstChar = Email.codePointAt(0);
            if(!(firstChar >= 90 && firstChar <= 122)){
            
                out.print("In Email First Character must be small.");
                return;
            }
            
            int count = 0;
            String eSplit[] = Email.split("@");
            for(int i=0; i<Email.length(); i++){
            
                if(Email.charAt(i) == '@'){
                
                    count++;
                }
                
            }
            if(count != 1){
                    out.print(count);
                    out.print("In Email Occurance of '@' is not maintained Properly.");
                }
            
            for(int i=0; i<Username.length(); i++){
            
                int Unicode = Email.codePointAt(i);
                if(!((Unicode > 64 && Unicode <= 90) || (Unicode >= 97 && Unicode <= 122) || (Unicode == 95) || 
                     (Unicode >= 48 && Unicode <= 57))){
                     
                   out.print("Special Symbol is not Allowed in the Username.");
                   return;
               }   
            }
            
            String Password = request.getParameter("password");
            String ConfirmPassword = request.getParameter("confirm password");
            if(!Password.equals(ConfirmPassword)){
            
                out.print("Password & Confirm Password must be Same.");
                return;
            }
               
            String MobileNumber = request.getParameter("mobilenumber");
            if(MobileNumber.length() > 10){
            
                out.print("Invalid Mobile Number !!");
                return;
            }
       
            String Branch = request.getParameter("branch");
            if(!(Branch.equals("computer") || Branch.equals("information"))){
            
                out.print("Branch must be Computer or IT.");
                return;
            }
            
            String CollegeName = request.getParameter("college");
            for(int i=0; i<CollegeName.length(); i++){
               int Unicode = CollegeName.codePointAt(i);
               if(!((Unicode > 64 && Unicode <= 90) || (Unicode >= 97 && Unicode <= 122) || (Unicode == 95) || 
                    (Unicode >= 48 && Unicode <= 57))){
                     
                   out.print("Special Symbol is not Allowed in the College Name.");
                   return;
               }   
            }

            response.sendRedirect("Approved.html");
            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
