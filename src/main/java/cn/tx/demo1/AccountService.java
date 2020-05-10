package cn.tx.demo1;

import java.sql.SQLException;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public interface AccountService {

    // 保存2个账号
    public void saveAll(Account account1,Account account2) throws SQLException;

}
