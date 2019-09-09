package org.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user = new User();
        user.setId(1);
        user.setName("xyd");
        createSQL(user);
        
    }

    public static void createSQL(User userTest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class user = userTest.getClass();
        StringBuilder sb = new StringBuilder();
        if (user.isAnnotationPresent(Table.class)) {
            Table table = (Table) user.getAnnotation(Table.class);
            String tableName = table.value();
            sb.append("select * from ").append(tableName);
            Field[] fields = user.getDeclaredFields();
            sb.append(" where 1=1");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    // 得到列名
                    String value = column.value();
                    String name = field.getName();
                    String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
                    @SuppressWarnings("unchecked")
                    Method method = user.getMethod("get" + methodName);
                    Object ob = method.invoke(userTest);
                    if (ob != null) {
                        if (ob instanceof Integer) {
                            sb.append(" and ").append(value).append("=").append(ob);
                        }
                        if (ob instanceof String) {
                            sb.append(" and ").append(value).append("=").append("'").append(ob).append("'");
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
