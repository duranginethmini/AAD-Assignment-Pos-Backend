package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerBO {
    String saveCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException;
    boolean updateCustomer(String id,CustomerDTO customerDTO,Connection connection) throws SQLException;
    boolean deleteCustomer(String id,Connection connection) throws SQLException;
    CustomerDTO getCustomer(String id,Connection connection) throws SQLException;
}
