package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "SearchUser3", urlPatterns = {"/SearchUser3"})
public class SearchUser3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Country.class);
        criteria.add(Restrictions.eq("name", "Sri Lanka"));

        Country country = (Country) criteria.uniqueResult();

        for (User user : (List<User>) country.getUserList()) {
            System.out.println(user.getName());
        }

        session.close();

    }

}
