package com.wen.controller;

import com.wen.entity.Book;
import com.wen.entity.Reader;
import com.wen.service.BookService;
import com.wen.service.serviceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll":
                String page = req.getParameter("page");
                Integer pages = Integer.parseInt(page);
                List<Book> list = bookService.findAll(pages);
                req.setAttribute("list", list);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", pages);
                req.setAttribute("pages", bookService.getPages());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "addBorrow":
                String bookid = req.getParameter("bookid");
                Integer id = Integer.parseInt(bookid);
                HttpSession session = req.getSession();
                Reader reader = (Reader) session.getAttribute("reader");
                bookService.addBorreow(id, reader.getId());
                break;
            default:
                break;
        }


    }
}
