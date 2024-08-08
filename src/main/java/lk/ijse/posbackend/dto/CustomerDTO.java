package lk.ijse.posbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CustomerDTO {
    private String custId;
    private String custName;
    private String custAddress;
    private String custSalary;
}
