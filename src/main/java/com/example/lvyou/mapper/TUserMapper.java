package com.example.lvyou.mapper;
import com.example.lvyou.bean.TUserBean;

import java.util.List;

public interface TUserMapper {
    TUserBean loginT(String tname, String tpwd);

    List<TUserBean> selectTU();

    void deleteTU(String tname, String tpwd);

    void updateTU(String tname, String tpwd, String tsex, int tage, String tphone);
}
