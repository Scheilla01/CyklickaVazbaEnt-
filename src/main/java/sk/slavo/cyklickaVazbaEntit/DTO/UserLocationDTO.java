package sk.slavo.cyklickaVazbaEntit.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// oprava zacyklenia entit

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLocationDTO {
    private long userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;
}