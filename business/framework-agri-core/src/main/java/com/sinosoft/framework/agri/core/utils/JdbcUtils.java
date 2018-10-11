package com.sinosoft.framework.agri.core.utils;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-05-26 12:51
 */
public class JdbcUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(JdbcUtils.class);
    public static Map<String, String> mapType;
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    private final String DRIVER_CLASS_NAME;
//    public JdbcUtils() {
//    }

    public JdbcUtils(String driverClassName,String url, String userName, String password) {
        mapType = new HashMap<>();
        mapType.put("java.lang.Integer", "int");
        mapType.put("java.lang.Double", "double");
        mapType.put("java.lang.Float", "float");
        mapType.put("java.lang.Long", "long");
        mapType.put("java.lang.Short", "short");
        mapType.put("java.lang.Byte", "byte");
        mapType.put("java.lang.Boolean", "boolean");
        mapType.put("java.lang.Character", "string");
        mapType.put("java.lang.String", "string");
        mapType.put("java.util.Date", "date");
        mapType.put("int", "int");
        mapType.put("double", "double");
        mapType.put("long", "long");
        mapType.put("short", "short");
        mapType.put("byte", "byte");
        mapType.put("boolean", "boolean");
        mapType.put("char", "string");
        mapType.put("float", "float");
        DRIVER_CLASS_NAME = driverClassName;
        URL = url;
        USERNAME = userName;
        PASSWORD = password;
    }

    /**
     * 获取sql coonnection
     *
     * @return
     */
    private Connection getConn() {
        long n1 = System.currentTimeMillis();
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("创建连接异常：" + e);
        }
        LOGGER.debug("sql connect：" + (System.currentTimeMillis() - n1));
        return conn;
    }

    /**
     * 批量插入
     *
     * @param list
     * @return 返回影响行数
     */
    public int[] insertBatch(List list) {
        long n1 = System.currentTimeMillis();
        int[] n = null;
        if (list == null || list.isEmpty()) {
            return n;
        }
        this.executePrePersist(list);
        //根据对象反射生成sql
        String sql = parseSql(list.get(0));
        if (sql == null || sql.isEmpty()) {
            LOGGER.info("无sql生成：" + list.get(0).toString());
            //TODO 业务处理
            return n;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            n1 = System.currentTimeMillis();
            conn = getConn();
            LOGGER.info("建立连接：" + (System.currentTimeMillis() - n1));

            n1 = System.currentTimeMillis();
            //事务手动提交
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            for (Object te : list) {
                //参数赋值
                setPreStatement(te, pstmt);
                pstmt.addBatch();
            }
            n = pstmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("insertBatch异常", e);
            try {
                //异常回滚
                conn.rollback();
                n = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.debug("insertBatch：" + (System.currentTimeMillis() - n1));
        return n;
    }


    /**
     * 解析sql
     *
     * @param object
     * @return
     */
    public String parseSql(Object object) {
        Class<?> clazz = object.getClass();
        String columnName;
        StringBuilder sql = new StringBuilder();
        String tableName = getTable(object);
        StringBuilder sqlValues = new StringBuilder();
        String dataType;
        int i = 0;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    columnName = getFieldAnnota(field);
                    if (columnName != null && !columnName.isEmpty()) {
                        if (i > 0) {
                            sql.append(",");

                            sqlValues.append(",");
                        }
                        sql.append(columnName);

                        //获取value
                        field.setAccessible(true);
                        Object value = field.get(object);
                        dataType = field.getType().getTypeName();
                        dataType = mapType.get(dataType);
                        //field.isSynthetic()
                        sqlValues.append("?");
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("生成sql错误：", e);
            }
        }

        if (sql.length() > 0) {
            String result = "insert into " + tableName + " (" + sql.toString() + ") values (" + sqlValues.toString() + ")";
            sql.setLength(0);
            sqlValues.setLength(0);
            LOGGER.debug("生成sql：" + result);
            return result;
        } else {
            return null;
        }
    }

    /**
     * 参数赋值
     *
     * @param object
     * @param pstmt
     */
    public void setPreStatement(Object object, PreparedStatement pstmt) {
        Class<?> clazz = object.getClass();
        //列名
        String columnName;
        //列数据类型
        String dataType;
        int index = 0;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //获取列注解名称，不写注解将无效，不持久化
                    columnName = getFieldAnnota(field);
                    if (columnName != null && !columnName.isEmpty()) {
                        index++;
                        //获取value
                        field.setAccessible(true);
                        Object value = field.get(object);
                        dataType = field.getType().getTypeName();
                        dataType = mapType.get(dataType);

                        //#region 数据类型判断 根据类型赋值
                        switch (dataType) {
                            case "string": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.VARCHAR);
                                    break;
                                }
                                pstmt.setString(index, value.toString());
                                break;
                            }
                            case "date": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.DATE);
                                    break;
                                }
                                pstmt.setDate(index, new Date(((java.util.Date) value).getTime()));
                                break;
                            }
                            case "int": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.INTEGER);
                                    break;
                                }
                                pstmt.setInt(index, (int) value);
                                break;
                            }
                            case "double": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.DOUBLE);
                                    break;
                                }
                                pstmt.setDouble(index, (double) value);
                                break;
                            }
                            case "long": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.BIGINT);
                                    break;
                                }
                                pstmt.setLong(index, (long) value);
                                break;
                            }
                            case "short": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.SMALLINT);
                                    break;
                                }
                                pstmt.setShort(index, (short) value);
                                break;
                            }
                            case "byte": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.BIT);
                                    break;
                                }
                                pstmt.setByte(index, (byte) value);
                                break;
                            }
                            case "boolean": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.BOOLEAN);
                                    break;
                                }
                                pstmt.setBoolean(index, (boolean) value);
                                break;
                            }
                            case "char": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.CHAR);
                                    break;
                                }
                                pstmt.setString(index, (String) value);
                                break;
                            }
                            case "float": {
                                if (value == null) {
                                    pstmt.setNull(index, Types.FLOAT);
                                    break;
                                }
                                pstmt.setFloat(index, (float) value);
                                break;
                            }
                            default: {
                                if (value == null) {
                                    pstmt.setNull(index, Types.VARCHAR);
                                }
                                pstmt.setObject(index, value);
                            }
                        }
                        //#endregion

                        //LOGGER.debug(index+" "+dataType + " " + value + " " + field.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取表名
     *
     * @param object
     * @return
     */
    public String getTable(Object object) {
        Class<?> clazz = object.getClass();
        //entity 注解 表名
        Annotation[] annotations = clazz.getAnnotations();
        String tableName = clazz.getSimpleName();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Table) {
                Table myAnnotation = (Table) annotation;
                return myAnnotation.name();
            }
        }
        return tableName;
    }

    /**
     * 获取列名注解
     *
     * @param field
     * @return
     */
    public String getFieldAnnota(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Column) {
                Column myAnnotation = (Column) annotation;
                return myAnnotation.name();
            }
        }
        return null;
    }

    /**
     * 执行list中所有带有PrePersist注解的方法
     *
     * @param list
     */
    private void executePrePersist(List list) {
        for (Object obj : list) {
            Class<?> aClass = obj.getClass();
            for (; aClass != Object.class; aClass = aClass.getSuperclass()) {
                if (BaseEntityImpl.class.equals(aClass)) {
                    Method[] methods = aClass.getDeclaredMethods();
                    Method.setAccessible(methods, true);
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(PrePersist.class)) {
                            try {
                                method.invoke(obj);
                            } catch (Exception e) {
                                e.printStackTrace();
                                LOGGER.error("executePrePersist错误：", e);
                            }
                        }
                    }
                }
            }
        }
    }
}
