package Junit5.demo;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

/**
 * @program:
 * @description:实现不依赖IDEA进行脚本的运行使用api的方式启动
 * @author: Mr.libb
 * @creat: 2022-06-14 18-07
 **/
public class Launcher {
    public static void main(String[] args){
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBulider.request()
                .selectors(
                        //可以添加要执行那些方法
                        selectPackage("")
 //                       selectClass(Junit5Demo01.class)
  //                      selectMethod("Junit5.demo.Junit5Demo01#entityTest")
                )
                .filters(
          //              excludClassNamePatterns(".*方法名称的后缀")
                          includClassNamePatterns("")
                )
                .build();
        Launcher launcher = LauncherFactory.create();
        //Register a listener of your choice
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestEcecutionListeners(listener);
        launcher.execute(request);
    }
}
