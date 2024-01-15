package com.example.lvyou.mapper;
import com.example.lvyou.bean.*;

import java.util.List;

public interface AUserMapper {
    AUserBean loginU(String aname, String apwd);

    List<AUserBean> selectU();

    void addU(int aid, String aname, String apwd, String adate, int asalary, String aother);

    void addTU(int tnum, String tname, String tpwd, String tsex, int tage, String tphone, String tephone);

    List<PlaceBean> selectPU();

    void addPU(int placenum, String placename, String place, int star, int ticket, String placeother);

    void addTeamU(int teamnum, String teamname, String teamphone, int teamrnum, String teamother);

    List<TeamBean> selectTeamU();

    List<RouteBean> selectRU();

    void addRU(int routenum, String specialplace, String begin, String end, int longtime);

    List<ManageBean> selectMU();

    void addMU(int mnum, int tusernum, int teamnum, String manage, String mdate, String mother);

    void updateMU(int mnum, int tusernum, int teamnum, String manage, String mdate, String mother);

    List<ManageBean> selectMUmanage(String manage);

    List<ManageBean> selectMUteamnum(int teamnum);

    List<ManageBean> selectMUteamnum_manage(String manage,int teamnum);

    List<ManageBean> selectMUtusernum_manage(String manage, int tusernum);
}
