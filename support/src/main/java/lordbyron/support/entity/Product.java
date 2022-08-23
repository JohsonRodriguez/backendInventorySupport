package lordbyron.support.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {
    @Id
    private String id;
    private String type;
    private String brand;
    private String model;
    private String serial;
    private String colour;
    private String processor;
    private String ram;
    private String details_ram;
    private String disk;
    private String details_disk;
    private String video;
    private String details_video;
    private String mainboard;
    private String inches;
    private String lamp;
    private String details;
    private String observation;
    private String status;
    private String year;
    private String location;
}
