package com.example.lvyou.service;
import com.example.lvyou.bean.TUserBean;

import java.util.List;

public interface TUserService{
    TUserBean loginT(String name, String pwd);

    List<TUserBean> selectTU();

    void deleteTU(String name, String pwd);

    void updateTU(String name, String pwd, String sex, int age, String phone);
}
