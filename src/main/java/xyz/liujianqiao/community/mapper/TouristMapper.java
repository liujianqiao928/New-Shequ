package xyz.liujianqiao.community.mapper;


import xyz.liujianqiao.community.model.Tourist;
import xyz.liujianqiao.community.model.TouristExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TouristMapper {


    Tourist findById(@Param("id") Long id);

    Tourist find(@Param("usercode") String usercode, @Param("password") String password);

    List<Tourist> selectByExample(TouristExample touristExample);

    int insert(Tourist tourist);
    int update(@Param("email") String email, @Param("password") String password ,@Param("usercode") String usercode);
}