package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Country;
import model.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "SearchUser2", urlPatterns = {"/SearchUser2"})
public class SearchUser2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(User.class);

        ArrayList<User> userList = (ArrayList<User>) criteria.list();

        for (User user1 : userList) {
            System.out.println(user1.getId());
            System.out.println(user1.getName());
            System.out.println(user1.getMobile());
            System.out.println(user1.getCountry().getName());
        }

//        Country country = (Country) session.load(Country.class, 1);
//
//        List<User> user = country.getUserList();
//        
//        for (User user1 : user) {
//            
//            System.out.println(user1.getName());
//            
//        }
        
        session.close();

    }

}
