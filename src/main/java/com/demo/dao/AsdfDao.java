package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.entity.Asdf;

public interface AsdfDao {
	
     
	
	public List<Asdf> findAsdf();

	public Integer insertAopDemo(Asdf a);

	public Asdf findAsdfById(Map<String, Object> map);
	public Asdf findAsdfByIdForUpdate(Map<String, Object> map);

	public int subtractValid(Map<String,Object> map);


	public int plusValidSetPeriod(Map<String, Object> map);

	public void plusValidAddPeriod(Map<String, Object> map);

	public int insertDemo(Asdf asdf);

	public int insertBatchDemo(List<Asdf> list);

	

}
