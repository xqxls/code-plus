package com.xqxls.util;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2023/11/8 14:32
 */
public class JavaTypes {

    /***
     * 根据java.sql.Types的值返回java的类型
     * @param value
     * @return
     */
    public static String getType(int value){
        switch (value){
            case -7:
            case -6:
            case 5:
            case 4:
                return "java.lang.Integer";
            case -5:
            case 3:
                return "java.lang.Long";
            case 6:
                return "java.lang.Float";
            case 8:
                return "java.lang.Double";
            case 1:
            case 12:
            case -1:
                return "java.lang.String";
            case 91:
                return "java.time.LocalDate";
            case 92:
                return "java.time.LocalTime";
            case 93:
                return "java.time.LocalDateTime";
            case 16:
                return "java.lang.Boolean";
            default:
                return "java.lang.String";
        }
    }

    public static String getType(int value,int size,int scale){
        if(value == 3){
            if(size>0&&size<=1){
                return "java.lang.Boolean";
            }
            else if(size>1&&size<=10){
                return "java.lang.Integer";
            }
            else if(size>10&&size<=19){
                if(scale>0){
                    return "java.math.BigDecimal";
                }
                else{
                    return "java.lang.Long";
                }
            }
        }
        else if(value == 6){
            return "java.lang.Double";
        }
        else if(value == 12){
            return "java.lang.String";
        }
        else if(value == 93){
            if(size == 7){
                return "java.time.LocalDate";
            }
            else if(size == 11){
                return "java.time.LocalDateTime";
            }
        }
        else{
            return "java.lang.String";
        }
        return "java.lang.String";
    }

    /***
     * 去掉数据类型的包
     * @param type
     * @return
     */
    public static String simpleName(String type){
        return type.replace("java.lang.","").replaceFirst("java.util.","").replace("java.time.","").replace("java.math.","");
    }

    /***
     * 去掉数据类型的包，并且首字母小写
     * @param type
     * @return
     */
    public static  String simpleNameLowerFirst(String type){
        //去掉前缀
        type = simpleName(type);
        //将第一个字母转成小写
        return StringUtils.firstLower(type);
    }

}
