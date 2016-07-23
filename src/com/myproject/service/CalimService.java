package com.myproject.service;

import java.util.List;
import java.util.Map;

import com.myproject.vo.FindingRecords;

public interface CalimService {
	/**
	 * 认领服务
	 */
	
	/**
	 * 添加认领记录
	 */
  public int addClaimRecords(FindingRecords findingrecords );
  //按照学号查找我的认领
  public List<Map<String,Object>> findAllByUserId(String userId);
}
