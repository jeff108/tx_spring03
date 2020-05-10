package cn.tx.demo1;

import java.sql.SQLException;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 对saveAll方法进行增强
     * @param account1
     * @param account2
     * @throws SQLException
     */
    @Override
    public void saveAll(Account account1, Account account2) throws SQLException {
        // 保存1账号
        accountDao.save(account1);

        // 模拟异常
        // int a = 1/0;

        // 保存2账号
        accountDao.save(account2);
    }


    /**
     * 保存2个
     * @param account1
     * @param account2

    @Override
    public void saveAll(Account account1, Account account2) {
        try {
            // 开启事务
            TxUtils.startTransaction();
            // 保存1账号
            accountDao.save(account1);

            // 模拟异常
            // int a = 1/0;

            // 保存2账号
            accountDao.save(account2);
            // 提交事务/回滚事务
            TxUtils.commit();
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            // 回滚事务
            TxUtils.rollback();
        } finally {
            // 关闭资源
            TxUtils.close();
        }
    }
     */

}
