package nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;

/**
 * 转单查询服务。
 * 
 * @since 
 * @version  
 */
public interface IQuerypuzglForTRH102ZGL {

  /**
   * 转单查询服务，通过查询方案进行查询。
   * 
   * @param queryScheme
   * @return AggPu_caigouhet_zglMasterVO[]
   * @throws BusinessException
   */
  public AggPu_caigouhet_zglMasterVO[] queryByScheme(IQueryScheme queryScheme)  throws BusinessException;
  
  /**
   *  转单查询服务，通过sql语句进行查询。
   * 
   * @param queryScheme
   * @return AggPu_caigouhet_zglMasterVO[]
   * @throws BusinessException
   */
  public AggPu_caigouhet_zglMasterVO[] queryBySQL(String sql)  throws BusinessException;
}
