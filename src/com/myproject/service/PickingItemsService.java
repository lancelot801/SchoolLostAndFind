package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.Picking;

/**
 * ��ʰ��Ʒ����
 * @author dntch
 *
 */
public interface PickingItemsService {
	/**
	 * ��Ӽ�ʰ��Ʒ
	 * @param picking
	 * @return
	 */
	public int addPickingItems(Picking picking);
	/**
	 * ����ʱ�併���ѯĳһ�ε���Ϣ
	 */
	public List<Map<String,Object>> findTopItems(int n);
	/**
	 * ͨ����Ų�ѯ����
	 */
	public Map<String,Object> findPicking(int id);
	/**
	 * ��ѯ���м�ʰ����Ʒ
	 */
	public List<Map<String,Object>> findAllPicking();
	/**
	 * ͨ������ѯ���е���Ʒ
	 */
	public List<Map<String,Object>> findPickingByCategory(int category);
	/**
	 * ͨ��ѧ�Ų�ѯ���м�ʰ����Ʒ
	 */
	public List<Map<String,Object>> findPickingByUserId(String userId);
	/**
	 * ��ѯ���м�ʰ�Ĵ���˵���Ϣ
	 */
	public List<Map<String,Object>> findVaFind();
	/**
	 * ��˼�ʰ��Ϣ
	 */
	public int validatePick(int id);
}
