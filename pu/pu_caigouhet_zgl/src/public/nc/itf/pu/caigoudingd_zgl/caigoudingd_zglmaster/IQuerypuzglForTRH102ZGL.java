package nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;

/**
 * ת����ѯ����
 * 
 * @since 
 * @version  
 */
public interface IQuerypuzglForTRH102ZGL {

  /**
   * ת����ѯ����ͨ����ѯ�������в�ѯ��
   * 
   * @param queryScheme
   * @return AggPu_caigouhet_zglMasterVO[]
   * @throws BusinessException
   */
  public AggPu_caigouhet_zglMasterVO[] queryByScheme(IQueryScheme queryScheme)  throws BusinessException;
  
  /**
   *  ת����ѯ����ͨ��sql�����в�ѯ��
   * 
   * @param queryScheme
   * @return AggPu_caigouhet_zglMasterVO[]
   * @throws BusinessException
   */
  public AggPu_caigouhet_zglMasterVO[] queryBySQL(String sql)  throws BusinessException;
}
