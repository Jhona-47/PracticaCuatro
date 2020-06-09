
package com.emergentes.controlador;

import com.emergentes.modelo.Anuncio;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<Anuncio> lista = new ArrayList<Anuncio>();
        
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        
        PreparedStatement ps;
        ResultSet rs;
        
        if (op.equals("list")) {
            try {
                String sql = "select * from blog";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {                    
                    Anuncio anu = new Anuncio();
                    anu.setId(rs.getInt("id"));
                    anu.setFecha(rs.getString("fecha"));
                    anu.setTitulo(rs.getString("titulo"));
                    anu.setAnuncio(rs.getString("anuncio"));
                    
                    lista.add(anu);
                    
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }catch(SQLException ex) {
                System.out.println("Error en SQL 1"+ex.getMessage());
            }finally{
                canal.desconectar();
            }
        }
        if (op.equals("nuevo")) {
            Anuncio t = new Anuncio();
            request.setAttribute("anuncio", t);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                
                String sql = "delete from blog where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error de SQL 2"+ex.getMessage());
            } finally{
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }
        if (op.equals("editar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "select *  from blog where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                
                Anuncio re = new Anuncio();
                
                while (rs.next()) {                    
                    re.setId(rs.getInt("id"));
                    re.setFecha(rs.getString("fecha"));
                    re.setTitulo(rs.getString("titulo"));
                    re.setAnuncio(rs.getString("anuncio"));
                }
                request.setAttribute("anuncio", re);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("Error en SQL"+ex.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //int fecha = Integer.parseInt(request.getParameter("fecha"));
        String tituto = request.getParameter("titulo");
        String anuncio = request.getParameter("anuncio");
        
        Anuncio e = new Anuncio();
        SimpleDateFormat fechaa = new SimpleDateFormat("YYYY-MM-dd");
        String fe = fechaa.format(new Date());
        e.setId(id);
        e.setFecha(fe);
        e.setTitulo(tituto);
        e.setAnuncio(anuncio);
        
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
            
        if (id == 0) {
            String sql = "insert into blog(fecha,titulo,anuncio)values (?,?,?)";
            try {
                
                ps = conn.prepareStatement(sql);
                ps.setString(1, e.getFecha());
                ps.setString(2, e.getTitulo());
                ps.setString(3, e.getAnuncio());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error de sql 3"+ex.getMessage());
            }finally{
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }else{
            try {
                String sql = "update blog set fecha=?,titulo=?,anuncio=? where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, e.getFecha());
                ps.setString(2, e.getTitulo());
                ps.setString(3, e.getAnuncio());
                ps.setInt(4, e.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error de Actualizacion"+ex.getMessage());
            }
            response.sendRedirect("MainController");
        }
        
    }


}
