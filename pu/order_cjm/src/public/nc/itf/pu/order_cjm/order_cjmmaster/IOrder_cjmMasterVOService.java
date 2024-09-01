
package nc.itf.pu.order_cjm.order_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.vo.pu.order_cjm.Order_cjmMasterVO;
import nc.pub.billcode.vo.BillCodeContext;

public interface  IOrder_cjmMasterVOService{

	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  AggOrder_cjmMasterVO findAggOrder_cjmMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 条件
	 * @param orderPath 排序集合
	 * @return 结果数组
	 */
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public Order_cjmMasterVO[] listOrder_cjmMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  Order_cjmMasterVO findOrder_cjmMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listOrder_cjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listOrder_cjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * 给主实体vo设置默认值
	 * @param vo
	 */
	public void initDefaultData(Order_cjmMasterVO vo);
	
	
	/**
	 * 预新增操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * 预编辑操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggOrder_cjmMasterVO preEditAggOrder_cjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * 复制操作主实体数据
	 * 
	 */
	public AggOrder_cjmMasterVO copyAggOrder_cjmMasterVO(String pk) throws BusinessException;
	/**
	 * 保存操作主实体数据
	 * @param vos 保存对象
	 * @return @
	 */
	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo) throws BusinessException;

	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * 删除操作主实体数据
	 * @param vos 删除对象
	 * @return @
	 */
	public AggOrder_cjmMasterVO[] deleteAggOrder_cjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * 加载树类型数据主实体
	 * @param vos 对象
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;

	/**
	 * 根据主表主键查询子表pks
	 * @param childClazz 子表class
	 * @param parentId 主表主键
	 * @return 子表pks
	 * @throws BusinessException
	 */
	String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException;

	/**
	 * 根据子表主键查询子表数据
	 * @param childClazz 子表class
	 * @param pks 子表
	 * @return 子表vos
	 * @throws BusinessException
	 */
	SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException;
	/**
	 * 单个提交
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @param assign 指派信息，只有单个提交允许指派
	 * @return Object
	 * @throws BusinessException
	 */
	public Object commitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException;
	/**
	 * 批量提交
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @throws BusinessException
	 */
	public Object batchCommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * 单个收回
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @return
	 * @throws BusinessException
	 */
	public Object uncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * 批量收回
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @throws BusinessException
	 */
	public Object batchUncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * SAVEBASE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackSAVEBASE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * SAVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * UNSAVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackUNSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * APPROVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * UNAPPROVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackUNAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * 获取默认(全局)编码规则上下文
	 * 
	 * @param coderuleid 编码规则主键?
	 * @return 编码规则上下文
	 * @throws BusinessException
	 */
	public BillCodeContext getBillCodeContext(String coderuleid) throws BusinessException;

	/**
	 * 获取编码规则上下文
	 * 
	 * @param coderuleid
	 * @param pkgroup
	 * @param pkorg
	 * @return
	 * @throws BusinessException
	 */
	public BillCodeContext getBillCodeContext(String coderuleid, String pkgroup, String pkorg) throws BusinessException;

}