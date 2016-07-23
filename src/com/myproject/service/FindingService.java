package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.FindingRecords;
import com.myproject.vo.Losing;

/**
 * 寻找物品
 * @author dntch
 *
 */
public interface FindingService {
	/**
	 * 添加寻找物品
	 */
	public int addFindingItems(Losing losing);
	/**
	 * 查询物品前n条数据（通过）
	 */
	public List<Map<String,Object>> findTopLosingItems(int n);
	/**
	 * 通过id查询
	 */
	public Map<String,Object> findByItemsId(int id);
	/**
	 * 查询所有丢失的物品（通过）
	 */
	public List<Map<String,Object>> findAllFinding();
	/**
	 * 按照学号查询所有丢失的物品
	 * 
	 */
	public List<Map<String,Object>> findAllByUserId(String userId);
	/**
	 * 按照类别查询所有丢失的物品（通过）
	 */
	public List<Map<String,Object>> findFindingByCategory(int category);
	/**
	 * 查询所有丢失的待审核的信息
	 */
	public List<Map<String,Object>> findVaLose();
	/**
	 * 审核丢失信息
	 */
	public int validateFind(int id);
	
}
