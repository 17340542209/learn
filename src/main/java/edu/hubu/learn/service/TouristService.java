package edu.hubu.learn.service;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

    public List<Tourist> getTourists(){
        return touristDao.findAll(new Sort(Direction.DESC, "id"));
    }

	public Tourist addTourist(Tourist tourist) {
        return touristDao.save(tourist);
    }
    
    public void deleteTourist(Long id) {
        touristDao.deleteById(id);
    }

    public void modifyTourist(Tourist tourist) {
        touristDao.save(tourist);
	}

	public List<Tourist> searchTourist(String keyword) {
		return null;
	}

	


}