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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

@WebServlet(name = "SearchUser5", urlPatterns = {"/SearchUser5"})
public class SearchUser5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Criteria criteria  = session.createCriteria(User.class);
        
        criteria.addOrder(Order.asc("name"));
        
        List<User> userList = criteria.list();
        
        for (User user : userList) {
            System.out.println(user.getName());
        }
        
        session.close();

    }

  

}
