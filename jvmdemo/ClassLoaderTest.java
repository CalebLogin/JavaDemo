/**
 * ClassLoader Demo
 * @author：hanzhigang
 * @Date : 2021/3/1 9:26 PM
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

//      获取应用程序类加载器
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

//      获取其上层，扩展类加载器
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@61bbe9ba

//      获取其上层，试图获取启动类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

//      对于自定义类的加载器，使用默认的应用程序类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

//      String类使用启动类加载器进行加载的 --> java的核心类库都是使用启动类加载器进行加载的
        ClassLoader classLoaderString = String.class.getClassLoader();
        System.out.println(classLoaderString);//null

    }
}
