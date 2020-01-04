package com.myspring.day4.sys.service;

import java.math.BigDecimal;

public interface SimpleService {
    /*
    *
普通用户账号：
退出
查询余额
取款
存款
转账
    *
    * */
    void exit();
    BigDecimal seeMoney(int id);
    boolean save(int id,BigDecimal money);
    boolean take(int id,BigDecimal money);

    boolean transfer(int myid,int toid,BigDecimal money);

}
