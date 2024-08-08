package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemBO {
    String saveItem(ItemDTO itemDTO, Connection connection) throws SQLException;
    boolean updateItem(String id,ItemDTO itemDTO,Connection connection) throws SQLException;
    boolean deleteItem(String id,Connection connection) throws SQLException;
    ItemDTO getItem(String id,Connection connection) throws SQLException;
}
