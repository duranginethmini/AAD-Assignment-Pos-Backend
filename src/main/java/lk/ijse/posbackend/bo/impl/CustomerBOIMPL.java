package lk.ijse.posbackend.bo.impl;

import lk.ijse.posbackend.bo.CustomerBO;
import lk.ijse.posbackend.dao.impl.CustomerDAOIMPL;
import lk.ijse.posbackend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBOIMPL implements CustomerBO {
    @Override
    public String saveCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDAOIMPL();
        return customerDAOIMPL.saveCustomer(customerDTO, connection);
    }

    @Override
    public boolean updateCustomer(String id, CustomerDTO customerDTO, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDAOIMPL();
        return customerDAOIMPL.updateCustomer(id, customerDTO, connection);
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDAOIMPL();
        return customerDAOIMPL.deleteCustomer(id, connection);
    }

    @Override
    public CustomerDTO getCustomer(String id, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDAOIMPL();
        return customerDAOIMPL.getCustomer(id, connection);
    }
}
