package lk.ijse.posbackend.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class OrderDTO {
    private String orderId;
    private String cusId;
    private String itemCode;
    private LocalDate orderDate;
    private int orderQty;
    private double cash;
    private double discount;
    private double balance;

}
