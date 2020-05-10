package cn.tx.demo3;

import org.springframework.stereotype.Service;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void save() {
        System.out.println("保存订单...");
    }

}
