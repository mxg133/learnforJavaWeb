package test;

import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.User;
import utils.JDBCUtils;
import utils.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 孟享广
 * @date 2020-10-14 2:01 下午
 * @description
 */
public class JdbcUtilstest {
    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection3Druid();

        System.out.println(conn);
    }
}
