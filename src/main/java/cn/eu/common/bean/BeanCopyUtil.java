package cn.eu.common.bean;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanCopyUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T sourceObj){
        if (sourceObj==null)
            return null;
        return (T) copy(sourceObj);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> List<T> clone(List<T> sourceObj){
        if (sourceObj==null)
            return null;
        return (List<T>) copy(sourceObj);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> Set<T> clone(Set<T> sourceObj){
        if (sourceObj==null)
            return null;
        return (Set<T>) copy(sourceObj);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> Map<String,T> clone(Map<String,T> sourceObj){
        if (sourceObj==null)
            return null;
        return (Map<String,T>) copy(sourceObj);
    }

    private  static Object copy(Object sourceObj){

        Object cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(sourceObj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            cloneObj = ois.readObject();
            //返回生成的新对象

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
