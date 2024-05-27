package resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Divakar Verma
 * @created_at : 27/05/2024 - 12:17 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserInfo {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
}
