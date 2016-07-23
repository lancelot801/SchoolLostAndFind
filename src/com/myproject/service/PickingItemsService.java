package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.Picking;

/**
 * 捡拾物品服务
 * @author dntch
 *
 */
public interface PickingItemsService {
	/**
	 * 添加捡拾物品
	 * @param picking
	 * @return
	 */
	public int addPickingItems(Picking picking);
	/**
	 * 按照时间降序查询某一段的信息
	 */
	public List<Map<String,Object>> findTopItems(int n);
	/**
	 * 通过编号查询详情
	 */
	public Map<String,Object> findPicking(int id);
	/**
	 * 查询所有捡拾的物品
	 */
	public List<Map<String,Object>> findAllPicking();
	/**
	 * 通过类别查询所有的物品
	 */
	public List<Map<String,Object>> findPickingByCategory(int category);
	/**
	 * 通过学号查询所有捡拾的物品
	 */
	public List<Map<String,Object>> findPickingByUserId(String userId);
	/**
	 * 查询所有捡拾的待审核的信息
	 */
	public List<Map<String,Object>> findVaFind();
	/**
	 * 审核捡拾信息
	 */
	public int validatePick(int id);
}
