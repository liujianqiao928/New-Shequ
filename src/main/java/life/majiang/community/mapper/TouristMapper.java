package life.majiang.community.mapper;


import life.majiang.community.model.Tourist;
import life.majiang.community.model.TouristExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TouristMapper {


    Tourist findById(@Param("id") Long id);

    Tourist find(@Param("usercode") String usercode, @Param("password") String password);

    List<Tourist> selectByExample(TouristExample touristExample);

    int insert(Tourist tourist);
}