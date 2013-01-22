package com.jysoft.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.jysoft.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByName(String name);

	User findByLoginName(String loginName);
}
