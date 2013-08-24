package org.springside.examples.showcase.repository.mybatis;

import java.util.List;
import java.util.Map;

import org.springside.examples.showcase.entity.Message;
import org.springside.examples.showcase.entity.User;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author calvin
 */
@MyBatisRepository
public interface UserMybatisDao {

	public User get(Long id);

	public List<User> search(Map<String, Object> parameters);
	
	public List<Message> searchMessage(Map<String, Object> parameters);

	public void save(User user);

	public void delete(Long id);

}
