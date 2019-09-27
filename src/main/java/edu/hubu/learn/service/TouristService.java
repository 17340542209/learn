package edu.hubu.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.TouristDao;
import edu.hubu.learn.entity.Tourist;


@Service
public class TouristService {

    @Autowired
    private TouristDao touristDao ;

    public Tourist getTourist(Long id) {
        return touristDao.findById(id).get();
    }
}