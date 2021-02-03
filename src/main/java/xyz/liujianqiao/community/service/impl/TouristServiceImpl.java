package xyz.liujianqiao.community.service.impl;


import xyz.liujianqiao.community.mapper.TouristMapper;
import xyz.liujianqiao.community.model.Tourist;
import xyz.liujianqiao.community.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristMapper touristMapper;
    @Override
    public Tourist find(String code, String password) {

        Tourist tourist = touristMapper.find(code, password);

//        if (tourist == null){
//            throw new CustomizeException(CustomizeErrorCode.LOGIN_OFF);
//        }
        return tourist;
    }

    @Override
    public int insert(Tourist tourist) {
        int insert = touristMapper.insert(tourist);
        return insert;
    }

    @Override
    public int update(String email, String password, String usercode) {
        return touristMapper.update(email,password,usercode);
    }
}
