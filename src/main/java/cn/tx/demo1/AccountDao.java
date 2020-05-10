package cn.tx.demo1;

import java.sql.SQLException;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public interface AccountDao {

    // 保存账户
    public void save(Account account) throws SQLException;

}
