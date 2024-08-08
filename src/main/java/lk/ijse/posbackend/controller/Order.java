package lk.ijse.posbackend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/orders",loadOnStartup = 3)
public class Order extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(Order.class);
    Connection connection;
    @Override
    public void init() throws ServletException {
        logger.info("Init method invoked");
        try {
            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/posManagement");
            this.connection = pool.getConnection();
            logger.info("Connection Initialized",this.connection);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
