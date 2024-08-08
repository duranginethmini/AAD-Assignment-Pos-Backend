package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO {
    String saveCustomer (CustomerDTO customer , Connection connection);
    boolean updateCustomer(String id,CustomerDTO customerDTO,Connection connection) throws SQLException;
    boolean deleteCustomer(String id,Connection connection) throws SQLException;
    CustomerDTO getCustomer(String id,Connection connection) throws SQLException;
}
