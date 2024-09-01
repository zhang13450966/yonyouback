
package nc.itf.pu.region_cjm.region_cjmmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.pu.region_cjm.Region_CjmMasterVO;

public interface  IRegion_CjmMasterVOService{


	/**
	 * ����-�½���������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String[] pks, boolean blazyLoad ) throws BusinessException;
	
	/**
	 * ����-�½���������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  Region_CjmMasterVO findRegion_CjmMasterVOByPk(String pk,  boolean blazyLoad) throws BusinessException;
	
	/**
	 * ����-�½���������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String condition,  boolean blazyLoad) throws BusinessException;
	/**
	 * ����-�½���������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listRegion_CjmMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ����-�½���������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listRegion_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(Region_CjmMasterVO vo);
	
	
	/**
	 * Ԥ������������-�½�������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Region_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭��������-�½�������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public Region_CjmMasterVO preEditRegion_CjmMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�������-�½�������
	 * 
	 */
	public Region_CjmMasterVO copyRegion_CjmMasterVO(String pk) throws BusinessException;
	/**
	 * �����������-�½�������
	 * @param vos �������
	 * @return @
	 */
	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO vo) throws BusinessException;

	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ����������-�½�������
	 * @param vos ɾ������
	 * @return @
	 */
	public Region_CjmMasterVO[] deleteRegion_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݴ���-�½���
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


	/**
	 *	������������
	 * 
	 * @param vos
	 * @return
	 * @throws BusinessException
	 */
	public void batchEnable(Region_CjmMasterVO[] vos) throws BusinessException;

	/**
	 *	��������ͣ��
	 * 
	 * @param vos
	 * @return
	 * @throws BusinessException
	 */
	public void batchDisable(Region_CjmMasterVO[] vos) throws BusinessException;
}