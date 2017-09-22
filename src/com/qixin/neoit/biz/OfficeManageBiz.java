package com.qixin.neoit.biz;

import java.util.List;

import com.qixin.neoit.entity.Sys_office;

public interface OfficeManageBiz {
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增部门
     * @param record
     * @return
     */
    int insert(Sys_office record);

    /**
     * 部门详情
     * @param id
     * @return
     */
    Sys_office selectByPrimaryKey(Integer id);

    /**
     * 修改部门
     * @param record
     * @return
     */
    int updateByPrimaryKey(Sys_office record);
    
    /**
     * 查询所有部门
     * @return
     */
    List<Sys_office> officeShow();
}
