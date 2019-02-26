/**
 * 创建日期 2017-11-3
 */
package com.xx.entity.test;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;



/**
 * 功能说明：
 * 
 * @author 邓锦烨 2017-11-3
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper
{
	@Cacheable
    @Select("SELECT * FROM T_USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

	@CachePut /** 用于实时更新内容到缓存 */
    @Insert("INSERT INTO T_USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
	
	@CacheEvict /** 用于同步删除缓存的数据 */
	@Delete("DELETE FROM T_USER WHERE ID=#{id}")
	void delete(@Param("id") int id);
}
