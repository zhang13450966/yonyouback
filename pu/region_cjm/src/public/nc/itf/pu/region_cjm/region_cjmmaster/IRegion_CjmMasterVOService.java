
package nc.itf.pu.region_cjm.region_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.pu.region_cjm.Region_CjmMasterVO;

public interface  IRegion_CjmMasterVOService{


	/**
	 * 大区-陈金明的主表VO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String[] pks, boolean blazyLoad ) throws BusinessException;
	
	/**
	 * 大区-陈金明的主表VO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  Region_CjmMasterVO findRegion_CjmMasterVOByPk(String pk,  boolean blazyLoad) throws BusinessException;
	
	/**
	 * 大区-陈金明的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String condition,  boolean blazyLoad) throws BusinessException;
	/**
	 * 大区-陈金明的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listRegion_CjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * 大区-陈金明的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listRegion_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * 给主实体vo设置默认值
	 * @param vo
	 */
	public void initDefaultData(Region_CjmMasterVO vo);
	
	
	/**
	 * 预新增操作大区-陈金明数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Region_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * 预编辑操作大区-陈金明数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public Region_CjmMasterVO preEditRegion_CjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * 复制操作大区-陈金明数据
	 * 
	 */
	public Region_CjmMasterVO copyRegion_CjmMasterVO(String pk) throws BusinessException;
	/**
	 * 保存操作大区-陈金明数据
	 * @param vos 保存对象
	 * @return @
	 */
	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO vo) throws BusinessException;

	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * 删除操作大区-陈金明数据
	 * @param vos 删除对象
	 * @return @
	 */
	public Region_CjmMasterVO[] deleteRegion_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * 加载树类型数据大区-陈金明
	 * @param vos 对象
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


	/**
	 *	档案批量启用
	 * 
	 * @param vos
	 * @return
	 * @throws BusinessException
	 */
	public void batchEnable(Region_CjmMasterVO[] vos) throws BusinessException;

	/**
	 *	档案批量停用
	 * 
	 * @param vos
	 * @return
	 * @throws BusinessException
	 */
	public void batchDisable(Region_CjmMasterVO[] vos) throws BusinessException;
}