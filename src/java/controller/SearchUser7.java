package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

@WebServlet(name = "SearchUser7", urlPatterns = {"/SearchUser7"})
public class SearchUser7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        Query query = session.createQuery("FROM User");
//        List<User> user = query.list();
//        for (User user1 : user) {
//            System.out.println(user1.getName());
//        }

        SQLQuery query = session.createSQLQuery("SELECT * FROM `user`");
        
        

    }

}
