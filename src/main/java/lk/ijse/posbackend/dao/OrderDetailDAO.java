package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.dto.OrderDetailDTO;

import java.sql.Connection;

public interface OrderDetailDAO {
    boolean saveOrderDetail(OrderDetailDTO orderDetailDTO, Connection connection) throws Exception;
}
