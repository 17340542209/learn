package edu.hubu.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hubu.learn.entity.Tourist;;

public interface TouristDao extends JpaRepository<Tourist, Long> {

}