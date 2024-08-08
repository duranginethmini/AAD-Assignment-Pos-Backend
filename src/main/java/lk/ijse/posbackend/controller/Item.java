package lk.ijse.posbackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.impl.ItemBOIMPL;
import lk.ijse.posbackend.dto.ItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item",loadOnStartup = 5)
public class Item extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(Item.class);
    Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        try (var writer = resp.getWriter()) {
            Jsonb jsonb = JsonbBuilder.create();
            var itemBOIMPL = new ItemBOIMPL();
            ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
            //Save data in the DB
            writer.write(itemBOIMPL.saveItem(itemDTO, connection));
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()) {
            var itemBOIMPL = new ItemBOIMPL();            var itemCode = req.getParameter("itemCode");
            Jsonb jsonb = JsonbBuilder.create();
            ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
            if(itemBOIMPL.updateItem(itemCode,itemDTO,connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Update failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()) {
            var itemCode = req.getParameter("itemCode");
            var itemBOIMPL = new ItemBOIMPL();
            if(itemBOIMPL.deleteItem(itemCode,connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Delete failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()) {
            var itemBOIMPL = new ItemBOIMPL();            Jsonb jsonb = JsonbBuilder.create();
            //DB Process
            var itemCode = req.getParameter("itemCode");;
            resp.setContentType("application/json");
            jsonb.toJson(itemBOIMPL.getItem(itemCode,connection),writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
