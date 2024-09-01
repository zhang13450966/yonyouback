
package nc.itf.pu.order_cjm.order_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.vo.pu.order_cjm.Order_cjmMasterVO;
import nc.pub.billcode.vo.BillCodeContext;

public interface  IOrder_cjmMasterVOService{

	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggOrder_cjmMasterVO findAggOrder_cjmMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public Order_cjmMasterVO[] listOrder_cjmMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  Order_cjmMasterVO findOrder_cjmMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listOrder_cjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listOrder_cjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(Order_cjmMasterVO vo);
	
	
	/**
	 * Ԥ����������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggOrder_cjmMasterVO preEditAggOrder_cjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʵ������
	 * 
	 */
	public AggOrder_cjmMasterVO copyAggOrder_cjmMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo) throws BusinessException;

	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggOrder_cjmMasterVO[] deleteAggOrder_cjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������ʵ��
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;

	/**
	 * ��������������ѯ�ӱ�pks
	 * @param childClazz �ӱ�class
	 * @param parentId ��������
	 * @return �ӱ�pks
	 * @throws BusinessException
	 */
	String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException;

	/**
	 * �����ӱ�������ѯ�ӱ�����
	 * @param childClazz �ӱ�class
	 * @param pks �ӱ�
	 * @return �ӱ�vos
	 * @throws BusinessException
	 */
	SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException;
	/**
	 * �����ύ
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @param assign ָ����Ϣ��ֻ�е����ύ����ָ��
	 * @return Object
	 * @throws BusinessException
	 */
	public Object commitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException;
	/**
	 * �����ύ
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchCommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @return
	 * @throws BusinessException
	 */
	public Object uncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchUncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * SAVEBASE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackSAVEBASE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * SAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * UNSAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackUNSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * APPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * UNAPPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggOrder_cjmMasterVO[] callbackUNAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException;
	
	/**
	 * ��ȡĬ��(ȫ��)�������������
	 * 
	 * @param coderuleid �����������?
	 * @return �������������
	 * @throws BusinessException
	 */
	public BillCodeContext getBillCodeContext(String coderuleid) throws BusinessException;

	/**
	 * ��ȡ�������������
	 * 
	 * @param coderuleid
	 * @param pkgroup
	 * @param pkorg
	 * @return
	 * @throws BusinessException
	 */
	public BillCodeContext getBillCodeContext(String coderuleid, String pkgroup, String pkorg) throws BusinessException;

}