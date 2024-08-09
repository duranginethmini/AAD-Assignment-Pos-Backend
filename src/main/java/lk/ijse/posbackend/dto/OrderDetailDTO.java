package lk.ijse.posbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDetailDTO {
    private String order_id;
    private String item_code;
    private int qty;
}
