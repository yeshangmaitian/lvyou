package com.example.lvyou.serviceimpl;

import com.example.lvyou.bean.*;
import com.example.lvyou.mapper.AUserMapper;
import com.example.lvyou.service.AUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AUserServiceImpl implements AUserService {
    @Resource
    private AUserMapper aUserMapper;

    @Override
    public AUserBean loginU(String aname, String apwd) {
        return aUserMapper.loginU(aname,apwd);
    }

    @Override
    public List<AUserBean> selectU() {
        return aUserMapper.selectU();
    }

    @Override
    public void addU(int num, String name, String pwd, String date, int salary, String other) {
        aUserMapper.addU(num,name,pwd,date,salary,other);
    }

    @Override
    public void addTU(int num, String name, String pwd, String sex, int age, String phone, String ephone) {
        aUserMapper.addTU(num,name,pwd,sex,age,phone,ephone);
    }

    @Override
    public List<PlaceBean> selectPU() {
        return aUserMapper.selectPU();
    }

    @Override
    public void addPU(int num, String name, String place, int star, int ticket, String other) {
        aUserMapper.addPU(num,name,place,star,ticket,other);
    }

    @Override
    public void addTeamU(int num, String name, String phone, int rnum, String other) {
        aUserMapper.addTeamU(num,name,phone,rnum,other);
    }

    @Override
    public List<TeamBean> selectTeamU() {
        return aUserMapper.selectTeamU();
    }

    @Override
    public List<RouteBean> selectRU() {
        return aUserMapper.selectRU();
    }

    @Override
    public void addRU(int num, String special, String begin, String end, int time) {
        aUserMapper.addRU(num,special,begin,end,time);
    }

    @Override
    public List<ManageBean> selectMU() {
        return aUserMapper.selectMU();
    }

    @Override
    public void addMU(int num, int tusernum, int teamnum, String manage, String date, String other) {
        aUserMapper.addMU(num,tusernum,teamnum,manage,date,other);
    }

    @Override
    public void updateMU(int num, int tusernum, int teamnum, String manage, String date, String other) {
        aUserMapper.updateMU(num,tusernum,teamnum,manage,date,other);
    }

    @Override
    public List<ManageBean> selectMUmanage(String manage) {
        return aUserMapper.selectMUmanage(manage);
    }

    @Override
    public List<ManageBean> selectMUteamnum(int teamnum) {
        return aUserMapper.selectMUteamnum(teamnum);
    }

    @Override
    public List<ManageBean> selectMUteamnum_manage(String manage,int teamnum) {
        return aUserMapper.selectMUteamnum_manage(manage,teamnum);
    }

    @Override
    public List<ManageBean> selectMUtusernum_manage(String manage, int tusernum) {
        return aUserMapper.selectMUtusernum_manage(manage,tusernum);
    }
}
