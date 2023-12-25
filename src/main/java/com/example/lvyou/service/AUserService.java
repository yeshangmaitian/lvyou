package com.example.lvyou.service;

import com.example.lvyou.bean.*;

import java.util.List;

public interface AUserService {
    AUserBean loginU(String name, String pwd);

    List<AUserBean> selectU();

    void addU(int num, String name, String pwd, String date, int salary, String other);

    void addTU(int num, String name, String pwd, String sex, int age, String phone, String ephone);

    List<PlaceBean> selectPU();

    void addPU(int num, String name, String place, int star, int ticket, String other);

    void addTeamU(int num, String name, String phone, int rnum, String other);

    List<TeamBean> selectTeamU();

    List<RouteBean> selectRU();

    void addRU(int num, String special, String begin, String end, int time);

    List<ManageBean> selectMU();

    void addMU(int num, int tusernum, int teamnum, String manage, String date, String other);

    void updateMU(int num, int tusernum, int teamnum, String manage, String date, String other);

    List<ManageBean> selectMUmanage(String manage);

    List<ManageBean> selectMUteamnum(int teamnum);

    List<ManageBean> selectMUteamnum_manage(String manage,int teamnum);

    List<ManageBean> selectMUtusernum_manage(String manage, int tusernum);
}
