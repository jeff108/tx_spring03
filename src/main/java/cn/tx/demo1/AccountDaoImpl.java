package cn.tx.demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class AccountDaoImpl implements AccountDao {

    /**
     * 保存
     * @param account
     */
    @Override
    public void save(Account account) throws SQLException {
        // System.out.println("持久层：保存账户...");
        // 把数据存储到数据库中
        // 先获取到连接
        Connection conn = TxUtils.getConnection();
        // 编写sql语句
        String sql = "insert into account values (null,?,?)";
        // 预编译SQL语句
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 设置值
        stmt.setString(1,account.getName());
        stmt.setDouble(2,account.getMoney());
        // 执行操作
        stmt.executeUpdate();
        // 关闭资源 ，conn不能关闭
        stmt.close();
    }

}
