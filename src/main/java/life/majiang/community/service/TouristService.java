package life.majiang.community.service;


import life.majiang.community.model.Tourist;
import org.springframework.stereotype.Service;

@Service
public interface TouristService {
  Tourist find(String code, String password);

    int insert(Tourist tourist);
}
