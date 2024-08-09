package lk.ijse.posbackend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String custId;
    private List<ItemDTO> items = new ArrayList<>();
    private Double total;
    private String discount;
    private Double subTotal;
    private Double cash;
    private Double balance;


}
