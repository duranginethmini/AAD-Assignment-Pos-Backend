package lk.ijse.posbackend.dao.impl;

import lk.ijse.posbackend.dao.ItemDAO;
import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDAOIMPL implements ItemDAO {
    public static String SAVE_ITEM = "INSERT INTO item (itemCode,itemName,qty,unitPrice) VALUES(?,?,?,?)";
    public static  String UPDATE_ITEM="UPDATE item SET itemName= ?,qty=?,unitPrice=? WHERE itemCode=?";
    public static String DELETE_ITEM = "DELETE FROM item WHERE itemCode = ?";
    public static String GET_ITEM = "SELECT * FROM item WHERE itemCode = ?";
    @Override
    public String saveItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(SAVE_ITEM);
            ps.setString(1, itemDTO.getItemCode());
            ps.setString(2, itemDTO.getItemName());
            ps.setString(3, String.valueOf(itemDTO.getQty()));
            ps.setString(4, String.valueOf(itemDTO.getUnitPrice()));
            if(ps.executeUpdate() != 0){
                return "Item Save Successfully";
            }else {
                return "Failed to Save Item";
            }
        }catch (SQLException e){
            try {
                throw new SQLException(e.getMessage());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public boolean updateItem(String id, ItemDTO itemDTO, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(UPDATE_ITEM);
            ps.setString(1, itemDTO.getItemName());
            ps.setString(2, String.valueOf(itemDTO.getQty()));
            ps.setString(3, String.valueOf(itemDTO.getUnitPrice()));
            ps.setString(4, id);
            return ps.executeUpdate() != 0;
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        var ps = connection.prepareStatement(DELETE_ITEM);
        ps.setString(1, id);
        return ps.executeUpdate() != 0;
    }

    @Override
    public ItemDTO getItem(String id, Connection connection) throws SQLException {
        try {
            ItemDTO itemDTO = new ItemDTO();
            var ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1, id);
            var rst = ps.executeQuery();
            while (rst.next()){
                itemDTO.setItemCode(rst.getString("itemCode"));
                itemDTO.setItemName(rst.getString("itemName"));
                itemDTO.setQty(Integer.parseInt(rst.getString("qty")));
                itemDTO.setUnitPrice(Integer.parseInt(rst.getString("unitPrice")));

            }
            return itemDTO;
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }
}
