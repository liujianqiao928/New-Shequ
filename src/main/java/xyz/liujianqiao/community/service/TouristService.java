package xyz.liujianqiao.community.service;


import xyz.liujianqiao.community.model.Tourist;
import org.springframework.stereotype.Service;

@Service
public interface TouristService {
  Tourist find(String code, String password);

    int insert(Tourist tourist);
  int update( String email, String password , String usercode);
}
