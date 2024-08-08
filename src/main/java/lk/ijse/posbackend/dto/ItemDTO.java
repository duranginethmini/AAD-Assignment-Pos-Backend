package lk.ijse.posbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class ItemDTO {
    private String itemCode;
    private String itemName;
    private int qty;
    private int unitPrice;
}
