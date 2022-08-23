package lordbyron.support.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
    private String type;
    private String brand;
    private String model;
    private String serial;
    private String colour;
    private String details;
    private String observation;
    private String status;
    private String location;
}
