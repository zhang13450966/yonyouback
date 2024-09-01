
package nc.itf.pu.office_cjm.office_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.pu.office_cjm.Office_CjmMasterVO;

public interface  IOffice_CjmMasterVOService{


	/**
	 * 办事处-陈金明的主表VO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String[] pks, boolean blazyLoad ) throws BusinessException;
	
	/**
	 * 办事处-陈金明的主表VO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  Office_CjmMasterVO findOffice_CjmMasterVOByPk(String pk,  boolean blazyLoad) throws BusinessException;
	
	/**
	 * 办事处-陈金明的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String condition,  boolean blazyLoad) throws BusinessException;
	/**
	 * 办事处-陈金明的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listOffice_CjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * 办事处-陈金明的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listOffice_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * 树表型节点 查询列表数据时走该方法查询
	 */
	public String[] listOffice_CjmMasterVOPkBySql(String searchSql,String pid,String treeNodePk) throws BusinessException;
	/**
	 * 给主实体vo设置默认值
	 * @param vo
	 */
	public void initDefaultData(Office_CjmMasterVO vo);
	
	
	/**
	 * 预新增操作办事处-陈金明数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Office_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * 预编辑操作办事处-陈金明数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public Office_CjmMasterVO preEditOffice_CjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * 复制操作办事处-陈金明数据
	 * 
	 */
	public Office_CjmMasterVO copyOffice_CjmMasterVO(String pk) throws BusinessException;
	/**
	 * 保存操作办事处-陈金明数据
	 * @param vos 保存对象
	 * @return @
	 */
	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO vo) throws BusinessException;

	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * 删除操作办事处-陈金明数据
	 * @param vos 删除对象
	 * @return @
	 */
	public Office_CjmMasterVO[] deleteOffice_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * 加载树类型数据办事处-陈金明
	 * @param vos 对象
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}