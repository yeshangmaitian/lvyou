package com.example.lvyou.serviceimpl;

import com.example.lvyou.bean.TUserBean;
import com.example.lvyou.mapper.AUserMapper;
import com.example.lvyou.mapper.TUserMapper;
import com.example.lvyou.service.TUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceimpl implements TUserService {
    @Resource
    private TUserMapper tUserMapper;

    @Override
    public TUserBean loginT(String name, String pwd) {
        return tUserMapper.loginT(name, pwd);
    }

    @Override
    public List<TUserBean> selectTU() {
        return tUserMapper.selectTU();
    }

    @Override
    public void deleteTU(String name, String pwd) {
        tUserMapper.deleteTU(name, pwd);
    }

    @Override
    public void updateTU(String name, String pwd, String sex, int age, String phone) {
        tUserMapper.updateTU(name, pwd, sex, age, phone);
    }
}
