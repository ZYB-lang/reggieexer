package cn.zyb.common;

/**
 * @ClassName BaseContext
 * @Description TODO基于BaseContext的工具类,用于保存和存取当前登录用户的ID
 * @Author ZYB
 * @Date 2023/3/6 20:32
 * @Version 1.0
 **/
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
