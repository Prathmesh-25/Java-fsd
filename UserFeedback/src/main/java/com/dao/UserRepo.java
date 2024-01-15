package com.dao;

import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.entity.UserFeedback;


@Repository
public interface UserRepo extends CrudRepository<UserFeedback, Integer> {

}
