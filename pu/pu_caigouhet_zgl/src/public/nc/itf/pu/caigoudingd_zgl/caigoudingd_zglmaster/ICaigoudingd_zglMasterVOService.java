
package nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO;
import nc.pub.billcode.vo.BillCodeContext;

public interface  ICaigoudingd_zglMasterVOService{

	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggCaigoudingd_zglMasterVO findAggCaigoudingd_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  Caigoudingd_zglMasterVO findCaigoudingd_zglMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listCaigoudingd_zglMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listCaigoudingd_zglMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(Caigoudingd_zglMasterVO vo);
	
	
	/**
	 * Ԥ����������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggCaigoudingd_zglMasterVO preAddAggCaigoudingd_zglMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggCaigoudingd_zglMasterVO preAddAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggCaigoudingd_zglMasterVO preEditAggCaigoudingd_zglMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʵ������
	 * 
	 */
	public AggCaigoudingd_zglMasterVO copyAggCaigoudingd_zglMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggCaigoudingd_zglMasterVO[] saveAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO vo) throws BusinessException;

	public AggCaigoudingd_zglMasterVO[] saveAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggCaigoudingd_zglMasterVO[] deleteAggCaigoudingd_zglMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
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
	public Object commitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException;
	/**
	 * �����ύ
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchCommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @return
	 * @throws BusinessException
	 */
	public Object uncommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * �����ջ�
	 * @param actionName �����ű�����
	 * @param tsMap  keyΪ����  valueΪts
	 * @throws BusinessException
	 */
	public Object batchUncommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException;
	/**
	 * SAVEBASE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggCaigoudingd_zglMasterVO[] callbackSAVEBASE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * SAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggCaigoudingd_zglMasterVO[] callbackSAVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNSAVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggCaigoudingd_zglMasterVO[] callbackUNSAVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * APPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggCaigoudingd_zglMasterVO[] callbackAPPROVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException;
	
	/**
	 * UNAPPROVE �ص�--�����ű�������
	 * @param vos
	 * @throws BusinessException
	 * @return
	 */
	public AggCaigoudingd_zglMasterVO[] callbackUNAPPROVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException;
	
 /**
  * puzglת������ǰ����
  * @param srcids puzgl���ε���id
  * @throws BusinessException
  */
 public AggCaigoudingd_zglMasterVO[] tranferpuzglToAggCaigoudingd_zglMasterVO(Map<String,String> pkTsMap) throws BusinessException;
 
 //�������ݽṹȷ����������һ�����ܵĽӿ�
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