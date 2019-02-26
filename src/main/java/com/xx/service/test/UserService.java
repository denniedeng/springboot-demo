/**
 * 创建日期 2017-11-3
 */
package com.xx.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xx.entity.test.User;
import com.xx.entity.test.UserMapper;

/**
 * 功能说明：User Service
 * 
 * @author 邓锦烨 2017-11-3
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 插入user表信息
	 * 
	 * @param name
	 * @param age
	 * @return
	 * @author 邓锦烨 2017-11-3
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public int insertUser(String name, int age) {
//		userMapper.insert("BBB", 20);
//		userMapper.insert("CCC", 20);
//		userMapper.insert("DDD", 20);
//		userMapper.insert("EEE", 20);
		return userMapper.insert(name, age);
	}

	/**
	 * 根据名称找user
	 * 
	 * @param name
	 * @return
	 * @author 邓锦烨 2017-11-3
	 */
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	/**
	 * 根据id删除user数据
	 * @param id
	 */
	public void deleteById(int id) {
		userMapper.delete(id);
	}
}
