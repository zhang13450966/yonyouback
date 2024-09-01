
package nc.itf.uapbd.patient.patientmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.vo.uapbd.patient.PatientMasterVO;

public interface  IPatientMasterVOService{

	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  AggPatientMasterVO findAggPatientMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 条件
	 * @param orderPath 排序集合
	 * @return 结果数组
	 */
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public PatientMasterVO[] listPatientMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  PatientMasterVO findPatientMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listPatientMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listPatientMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * 给主实体vo设置默认值
	 * @param vo
	 */
	public void initDefaultData(PatientMasterVO vo);
	
	
	/**
	 * 预新增操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggPatientMasterVO preAddAggPatientMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggPatientMasterVO preAddAggPatientMasterVO(AggPatientMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * 预编辑操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggPatientMasterVO preEditAggPatientMasterVO(String pk) throws BusinessException;
	
	 /**
	 * 复制操作主实体数据
	 * 
	 */
	public AggPatientMasterVO copyAggPatientMasterVO(String pk) throws BusinessException;
	/**
	 * 保存操作主实体数据
	 * @param vos 保存对象
	 * @return @
	 */
	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO vo) throws BusinessException;

	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * 删除操作主实体数据
	 * @param vos 删除对象
	 * @return @
	 */
	public AggPatientMasterVO[] deleteAggPatientMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * 加载树类型数据主实体
	 * @param vos 对象
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}