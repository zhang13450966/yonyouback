
package nc.itf.pu.office_cjm.office_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.pu.office_cjm.Office_CjmMasterVO;

public interface  IOffice_CjmMasterVOService{


	/**
	 * ���´�-�½���������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String[] pks, boolean blazyLoad ) throws BusinessException;
	
	/**
	 * ���´�-�½���������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  Office_CjmMasterVO findOffice_CjmMasterVOByPk(String pk,  boolean blazyLoad) throws BusinessException;
	
	/**
	 * ���´�-�½���������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String condition,  boolean blazyLoad) throws BusinessException;
	/**
	 * ���´�-�½���������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listOffice_CjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ���´�-�½���������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listOffice_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * �����ͽڵ� ��ѯ�б�����ʱ�߸÷�����ѯ
	 */
	public String[] listOffice_CjmMasterVOPkBySql(String searchSql,String pid,String treeNodePk) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(Office_CjmMasterVO vo);
	
	
	/**
	 * Ԥ�����������´�-�½�������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Office_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭�������´�-�½�������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public Office_CjmMasterVO preEditOffice_CjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ������´�-�½�������
	 * 
	 */
	public Office_CjmMasterVO copyOffice_CjmMasterVO(String pk) throws BusinessException;
	/**
	 * ����������´�-�½�������
	 * @param vos �������
	 * @return @
	 */
	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO vo) throws BusinessException;

	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ���������´�-�½�������
	 * @param vos ɾ������
	 * @return @
	 */
	public Office_CjmMasterVO[] deleteOffice_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݰ��´�-�½���
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}