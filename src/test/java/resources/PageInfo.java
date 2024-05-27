package resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 27/05/2024 - 12:19 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PageInfo {

    private String page;
    private String perPage;
    private String total;
    private String totalPage;
    private List<UserInfo> data;

}
