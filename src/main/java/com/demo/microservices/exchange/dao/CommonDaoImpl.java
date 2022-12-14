package com.demo.microservices.exchange.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonDaoImpl implements CommonDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(String id, Object value) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		} finally {
		}
		return result;
	}

	@Override
	public int update(String id, Object value) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

		return result;
	}

	@Override
	public int update(String id, Map<String, Object> map) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(id, map);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

		return result;
	}

	@Override
	public int delete(String id, Map<String, Object> map) throws Exception {
		int result = 0;

		try {
			result = sqlSession.delete(id, map);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

		return result;
	}

	@Override
	public int delete(String id, Object value) throws Exception {
		int result = 0;

		try {
			result = sqlSession.delete(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

		return result;
	}

	@Override
	public int deleteAll(String id) throws Exception {
		int result = 0;

		try {
			result = sqlSession.delete(id);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

		return result;
	}

	@Override
	public <T> List<T> selectList(String id, Map<String, Object> map) throws Exception {
		List<T> list = null;
		try {
			list = sqlSession.selectList(id, map);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
		return list;
	}

	@Override
	public <T> List<T> selectList(String id, Object value) throws Exception {
		List<T> list = null;
		try {
			list = sqlSession.selectList(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
		return list;
	}

	@Override
	public <T> List<T> selectList(String id) throws Exception {
		List<T> list = null;
		try {
			list = sqlSession.selectList(id);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
		return list;
	}

	@Override
	public <T> T selectOne(String id) throws Exception {
		try {
			return sqlSession.selectOne(id);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
	}

	@Override
	public <T> T selectOne(String id, Object value) throws Exception {
		try {
			return sqlSession.selectOne(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
	}

	@Override
	public <T> T selectOne(String id, Map<String, Object> map) throws Exception {
		try {
			return sqlSession.selectOne(id, map);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}
	}

	/**
	 * ???????????? : INSERT, UPDATE, DELETE
	 */
	@Override
	public void updateProcedure(String id, Object value) throws Exception {
		try {
			sqlSession.update(id, value);
		} catch (Exception e) {
			log.error("[ERROR]", e);

			throw e;
		}

	}

	/**
	 * SELECT : OUT ??????????????? SYS_REFCURSOR ????????? ????????? ?????????(INTEGER ???)
	 */
	@Override
	public <T> Map<String, T> selectOneProcedureMap(String id, Map<String, T> map) throws Exception {
		try {
			// select procedure ????????? map??? ????????????.
			sqlSession.selectOne(id, map);
			
			return map;
		} catch (Exception e) {
			log.error("[ERROR]", e);
			
			throw e;
		}
	}

	/**
	 * SELECT : OUT ??????????????? SYS_REFCURSOR(?????? ?????? ?????? ????????? ?????????)
	 */
	@Override
	public <T> Map<String, T> selectListProcedureMap(String id, Map<String, T> map) throws Exception{
		try {
			// select procedure ????????? map??? ????????????.
			sqlSession.selectList(id, map);
			
			return map;
		} catch (Exception e) {
			log.error("[ERROR]", e);
			
			throw e;
		}
	}
  
}
