
package nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;
import nc.pub.billcode.vo.BillCodeContext;

public interface  IPu_caigouhet_zglMasterVOService{

	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  AggPu_caigouhet_zglMasterVO findAggPu_caigouhet_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * 主实体的AGGVO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 条件
	 * @param orderPath 排序集合
	 * @return 结果数组
	 */
	public  AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg数组
	 * @param pk主键
	 * @return 结果数组
	 */
	public Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据主键条件查询Agg对象
	 * @param pk 主键
	 * @return 结果对象
	 */
	public  Pu_caigouhet_zglMasterVO findPu_caigouhet_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * 主实体的主表VO查询操作
	 * 根据条件字符串查询Agg数组
	 * @param condition 主键
	 * @return 结果数组
	 */
	public  Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listPu_caigouhet_zglMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * 主实体的主表pk查询操作
	 * 根据条件字符串查询pk数组数组
	 * @param condition 查询方案+
	 * @return 结果数组
	 */
	public String[] listPu_caigouhet_zglMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * 给主实体vo设置默认值
	 * @param vo
	 */
	public void initDefaultData(Pu_caigouhet_zglMasterVO vo);
	
	
	/**
	 * 预新增操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggPu_caigouhet_zglMasterVO preAddAggPu_caigouhet_zglMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggPu_caigouhet_zglMasterVO preAddAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * 预编辑操作主实体数据
	 * @param userJson  新增时需要的扩展参数对象
	 */
	public AggPu_caigouhet_zglMasterVO preEditAggPu_caigouhet_zglMasterVO(String pk) throws BusinessException;
	
	 /**
	 * 复制操作主实体数据
	 * 
	 */
	public AggPu_caigouhet_zglMasterVO copyAggPu_caigouhet_zglMasterVO(String pk) throws BusinessException;
	/**
	 * 保存操作主实体数据
	 * @param vos 保存对象
	 * @return @
	 */
	public AggPu_caigouhet_zglMasterVO[] saveAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO vo) throws BusinessException;

	public AggPu_caigouhet_zglMasterVO[] saveAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * 删除操作主实体数据
	 * @param vos 删除对象
	 * @return @
	 */
	public AggPu_caigouhet_zglMasterVO[] deleteAggPu_caigouhet_zglMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
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
	public Object commitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException;
	/**
	 * 批量提交
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @throws BusinessException
	 */
	public Object batchCommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * 单个收回
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @return
	 * @throws BusinessException
	 */
	public Object uncommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * 批量收回
	 * @param actionName 动作脚本编码
	 * @param tsMap  key为主键  value为ts
	 * @throws BusinessException
	 */
	public Object batchUncommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * SAVEBASE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackSAVEBASE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * SAVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackSAVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNSAVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackUNSAVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * APPROVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackAPPROVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNAPPROVE 回调--动作脚本处调用
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackUNAPPROVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
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