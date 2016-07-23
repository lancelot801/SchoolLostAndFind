package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.FindingRecords;
import com.myproject.vo.Losing;

/**
 * Ѱ����Ʒ
 * @author dntch
 *
 */
public interface FindingService {
	/**
	 * ���Ѱ����Ʒ
	 */
	public int addFindingItems(Losing losing);
	/**
	 * ��ѯ��Ʒǰn�����ݣ�ͨ����
	 */
	public List<Map<String,Object>> findTopLosingItems(int n);
	/**
	 * ͨ��id��ѯ
	 */
	public Map<String,Object> findByItemsId(int id);
	/**
	 * ��ѯ���ж�ʧ����Ʒ��ͨ����
	 */
	public List<Map<String,Object>> findAllFinding();
	/**
	 * ����ѧ�Ų�ѯ���ж�ʧ����Ʒ
	 * 
	 */
	public List<Map<String,Object>> findAllByUserId(String userId);
	/**
	 * ��������ѯ���ж�ʧ����Ʒ��ͨ����
	 */
	public List<Map<String,Object>> findFindingByCategory(int category);
	/**
	 * ��ѯ���ж�ʧ�Ĵ���˵���Ϣ
	 */
	public List<Map<String,Object>> findVaLose();
	/**
	 * ��˶�ʧ��Ϣ
	 */
	public int validateFind(int id);
	
}
