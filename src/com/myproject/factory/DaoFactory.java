package com.myproject.factory;

import com.myproject.dao.DataAccessDao;
import com.myproject.dao.impl.AccountDaoImpl;
import com.myproject.dao.impl.FindingRecordsDaoImpl;
import com.myproject.dao.impl.ItemsCategoryDaoImpl;
import com.myproject.dao.impl.ItemsDaoImpl;
import com.myproject.dao.impl.ItemsStatuesDaoImpl;
import com.myproject.dao.impl.LosingDaoImpl;
import com.myproject.dao.impl.PickingDaoImpl;
import com.myproject.dao.impl.PublishingDaoImpl;
import com.myproject.dao.impl.RoleDaoImpl;
import com.myproject.dao.impl.UserDaoImpl;
import com.myproject.vo.Account;
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Items;
import com.myproject.vo.ItemsCategory;
import com.myproject.vo.ItemsStatues;
import com.myproject.vo.Losing;
import com.myproject.vo.Picking;
import com.myproject.vo.Publishing;
import com.myproject.vo.Role;
import com.myproject.vo.User;

/**
 * 该类主要是封装了dao层数据访问的所有的方法
 * @author dntch
 *
 */
public class DaoFactory {
 
	private DataAccessDao<Account> accountDao;
	private DataAccessDao<FindingRecords> findRecordsDao;
	private DataAccessDao<Items> itemsDao;
	private DataAccessDao<ItemsStatues> itemsStateusDao;
	private DataAccessDao<Losing> losingDao;
	private DataAccessDao<Picking> pickingDao;
	private DataAccessDao<Publishing> publishingDao;
	private DataAccessDao<Role> roleDao;
	private DataAccessDao<User> userDao;
	private DataAccessDao<ItemsCategory> itemsCategoryDao;
	
	public DaoFactory(){
		this.accountDao = new AccountDaoImpl();
		this.findRecordsDao = new FindingRecordsDaoImpl();
		this.itemsDao = new ItemsDaoImpl();
		this.itemsStateusDao = new ItemsStatuesDaoImpl();
		this.losingDao = new LosingDaoImpl();
		this.pickingDao = new PickingDaoImpl();
		this.publishingDao = new PublishingDaoImpl();
		this.roleDao = new RoleDaoImpl();
		this.userDao = new UserDaoImpl();
		this.itemsCategoryDao = new ItemsCategoryDaoImpl();
	}

	public DataAccessDao<ItemsCategory> getItemsCategoryDao() {
		return itemsCategoryDao;
	}

	public void setItemsCategoryDao(DataAccessDao<ItemsCategory> itemsCategoryDao) {
		this.itemsCategoryDao = itemsCategoryDao;
	}

	public DataAccessDao<Account> getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(DataAccessDao<Account> accountDao) {
		this.accountDao = accountDao;
	}

	public DataAccessDao<FindingRecords> getFindRecordsDao() {
		return findRecordsDao;
	}

	public void setFindRecordsDao(DataAccessDao<FindingRecords> findRecordsDao) {
		this.findRecordsDao = findRecordsDao;
	}

	public DataAccessDao<Items> getItemsDao() {
		return itemsDao;
	}

	public void setItemsDao(DataAccessDao<Items> itemsDao) {
		this.itemsDao = itemsDao;
	}

	public DataAccessDao<ItemsStatues> getItemsStateusDao() {
		return itemsStateusDao;
	}

	public void setItemsStateusDao(DataAccessDao<ItemsStatues> itemsStateusDao) {
		this.itemsStateusDao = itemsStateusDao;
	}

	public DataAccessDao<Losing> getLosingDao() {
		return losingDao;
	}

	public void setLosingDao(DataAccessDao<Losing> losingDao) {
		this.losingDao = losingDao;
	}

	public DataAccessDao<Picking> getPickingDao() {
		return pickingDao;
	}

	public void setPickingDao(DataAccessDao<Picking> pickingDao) {
		this.pickingDao = pickingDao;
	}

	public DataAccessDao<Publishing> getPublishingDao() {
		return publishingDao;
	}

	public void setPublishingDao(DataAccessDao<Publishing> publishingDao) {
		this.publishingDao = publishingDao;
	}

	public DataAccessDao<Role> getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(DataAccessDao<Role> roleDao) {
		this.roleDao = roleDao;
	}

	public DataAccessDao<User> getUserDao() {
		return userDao;
	}

	public void setUserDao(DataAccessDao<User> userDao) {
		this.userDao = userDao;
	}
	
	

}
