package lordbyron.support.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leanDay;
    private String leanTime;
    private String leanObs;
    private String returnDay;
    private String returnTime;
    private String returnObs;
    private String serial;
    private String status;
    private String user;
    private String person;
}
