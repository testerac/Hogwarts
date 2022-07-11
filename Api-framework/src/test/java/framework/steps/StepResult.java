package framework.steps;

import lombok.Data;
import org.junit.jupiter.api.function.Executable;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-08 17-42
 **/
@Data
public class StepResult {
    private ArrayList<Executable> asserList;
    private HashMap<String,String> stepVariables = new HashMap<>();
}
