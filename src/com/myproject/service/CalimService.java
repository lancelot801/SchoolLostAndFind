package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.FindingRecords;

public interface CalimService {
	/**
	 * �������
	 */
	
	/**
	 * ��������¼
	 */
  public int addClaimRecords(FindingRecords findingrecords );
  //����ѧ�Ų����ҵ�����
  public List<Map<String,Object>> findAllByUserId(String userId);
}
