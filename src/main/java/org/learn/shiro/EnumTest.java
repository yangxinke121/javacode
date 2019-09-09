package org.learn.shiro;

/**
 * @author: yxk
 * @date: 2019-03-26 14:57
 */
public enum EnumTest {

    //
    XYD(1, "yudian"),
    XK(2, "xinke"),

    ;

    private Integer id;

    private String name;

    EnumTest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        EnumTest[] values = EnumTest.values();
        for (EnumTest value : values) {
            if (value.name.equals("yudian")) {
                System.out.println(value);
            }
        }
    }
}
