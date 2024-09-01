
package nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;
import nc.pub.billcode.vo.BillCodeContext;

public interface  IPu_caigouhet_zglMasterVOService{

	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggPu_caigouhet_zglMasterVO findAggPu_caigouhet_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggPu_caigouhet_zglMasterVO[] listAggPu_caigouhet_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  Pu_caigouhet_zglMasterVO findPu_caigouhet_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Pu_caigouhet_zglMasterVO[] listPu_caigouhet_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listPu_caigouhet_zglMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listPu_caigouhet_zglMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(Pu_caigouhet_zglMasterVO vo);
	
	
	/**
	 * Ԥ����������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggPu_caigouhet_zglMasterVO preAddAggPu_caigouhet_zglMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggPu_caigouhet_zglMasterVO preAddAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggPu_caigouhet_zglMasterVO preEditAggPu_caigouhet_zglMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʵ������
	 * 
	 */
	public AggPu_caigouhet_zglMasterVO copyAggPu_caigouhet_zglMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggPu_caigouhet_zglMasterVO[] saveAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO vo) throws BusinessException;

	public AggPu_caigouhet_zglMasterVO[] saveAggPu_caigouhet_zglMasterVO(AggPu_caigouhet_zglMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggPu_caigouhet_zglMasterVO[] deleteAggPu_caigouhet_zglMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
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
	public Object commitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException;
	/**
	 * �����ύ
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchCommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @return
	 * @throws BusinessException
	 */
	public Object uncommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchUncommitAggPu_caigouhet_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * SAVEBASE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackSAVEBASE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * SAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackSAVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNSAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackUNSAVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * APPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackAPPROVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNAPPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggPu_caigouhet_zglMasterVO[] callbackUNAPPROVE(AggPu_caigouhet_zglMasterVO...vos) throws BusinessException;
	
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