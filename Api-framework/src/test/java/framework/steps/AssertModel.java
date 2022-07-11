package framework.steps;

import lombok.Data;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-08 17-36
 **/
@Data
public class AssertModel {
    private String actual;
    private String matcher;
    private String expect;
    private String reason;

}
