package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.codeplatform.framework.service.ServiceSupport;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.IQuerypuzglForTRH102ZGL;

/**
 *
 * 
 * @version 
 * @since ncc
 * @author nccsys
 * @time 
 */
 
public class QuerypuzglForTRH102ZGLImpl  extends ServiceSupport  implements IQuerypuzglForTRH102ZGL{

  /**
   * 查询方法
   * 
   * @throws BusinessException 
   */
  @Override
  public AggPu_caigouhet_zglMasterVO[] queryByScheme(IQueryScheme scheme)
      throws BusinessException {
    try {
      String whereSQL =  scheme == null||scheme.getWhereSQLOnly()==null  ? " isnull(pu_pu_caigouhet_zglmaster.dr,0)=0 " : scheme.getWhereSQLOnly()+" and isnull(pu_pu_caigouhet_zglmaster.dr,0)=0 ";
      
      whereSQL+=" and pu_pu_caigouhet_zglmaster.billtype='puzgl' ";
      AggPu_caigouhet_zglMasterVO[] vos=queryBySQL(whereSQL);
      return vos;
    }
    catch (Exception e) {
      ExceptionUtils.marsh(e);
    }
    return null;
  }
  
  /**
   * 查询方法
   * @throws BusinessException 
   */
  @Override
  public AggPu_caigouhet_zglMasterVO[] queryBySQL(String sql)
      throws BusinessException {
    try { 
      AggPu_caigouhet_zglMasterVO[] vos=this.dao.listByCondition(AggPu_caigouhet_zglMasterVO.class, sql);
      return vos;
    }
    catch (Exception e) {
      ExceptionUtils.marsh(e);
    }
    return null;
  }
  

}

