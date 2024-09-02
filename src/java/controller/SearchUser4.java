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
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "SearchUser4", urlPatterns = {"/SearchUser4"})
public class SearchUser4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Country.class);

        criteria.add(Restrictions.or(
                Restrictions.eq("name", "Sri Lanka"),
                Restrictions.eq("name", "India")
        ));
        
        List<Country> countryList = criteria.list();

        Criteria criteria2 = session.createCriteria(User.class);
        
        criteria2.add(Restrictions.in("country", countryList));
        
        List<User> userList = criteria2.list();
        
        for (User user : userList) {
            System.out.println(user.getName());
        }
        session.close();
        

    }

}
