package com.wen.controller;

import com.wen.entity.Admin;
import com.wen.entity.Book;
import com.wen.entity.Reader;
import com.wen.service.BookService;
import com.wen.service.LoginService;
import com.wen.service.serviceImpl.BookServiceImpl;
import com.wen.service.serviceImpl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object object = loginService.login(username, password, type);
        if (object != null) {
            HttpSession session = req.getSession();
            switch (type) {
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin", admin);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader", reader);
                    resp.sendRedirect("/book?page=1");
                    break;
                default:
                    break;
            }

        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
