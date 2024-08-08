package lk.ijse.posbackend.bo.impl;

import lk.ijse.posbackend.bo.ItemBO;
import lk.ijse.posbackend.dao.impl.ItemDAOIMPL;
import lk.ijse.posbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemBOIMPL implements ItemBO {
    @Override
    public String saveItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        var itemDAOIMPL = new ItemDAOIMPL();
        return itemDAOIMPL.saveItem(itemDTO, connection);
    }

    @Override
    public boolean updateItem(String id, ItemDTO itemDTO, Connection connection) throws SQLException {
        var itemDAOIMPL = new ItemDAOIMPL();
        return itemDAOIMPL.updateItem(id, itemDTO, connection);
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        var itemDAOIMPL = new ItemDAOIMPL();
        return itemDAOIMPL.deleteItem(id, connection);
    }

    @Override
    public ItemDTO getItem(String id, Connection connection) throws SQLException {
        var itemDAOIMPL = new ItemDAOIMPL();
        return itemDAOIMPL.getItem(id, connection);
    }


}
