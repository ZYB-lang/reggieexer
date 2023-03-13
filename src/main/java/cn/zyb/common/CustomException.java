package cn.zyb.common;

/**
 * @ClassName CustomException
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/6 22:16
 * @Version 1.0
 **/
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
