package nc.impl.pu.office_cjm.office_cjmmaster;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nc.vo.pub.BusinessException;
import nc.codeplatform.framework.commons.DaoUtils;
import nc.vo.pubapp.AppContext;
import nc.bs.framework.common.NCLocator;
import nccloud.pubitf.baseapp.apprbac.IAppAndOrgPermQueryPubService;
import nc.uap.utils.InSQLCreator;

import nc.itf.pu.office_cjm.office_cjmmaster.IRegion_CjmMasterVOService;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
/**
 * 加载树数据 实现
 */
public class  Region_CjmMasterVOServiceImpl  implements IRegion_CjmMasterVOService{

	static DaoUtils dao = new DaoUtils();

	static InSQLCreator inSQLCreator = new InSQLCreator();
	
	public Region_CjmMasterVO[] loadTreeData(String appcode) throws BusinessException{
		String pkGroup = AppContext.getInstance().getPkGroup();
		return dao.listByCondition(Region_CjmMasterVO.class, " pk_org in (" + getPermOrg(appcode) +") or pk_org = 'GLOBLE00000000000000' or pk_org = '"+pkGroup+"'");
	}

	@Override
	public String[] getLowerLevelPks(String pk) throws BusinessException {
		Region_CjmMasterVO[] vos = dao.listByCondition(Region_CjmMasterVO.class, new Region_CjmMasterVO().getPKFieldName()+"='" + pk +"'");
		List<String> listpks = new ArrayList<>(100);
		listpks.add(pk);
		while(vos != null && vos.length > 0){
			List<String> pks = Stream.of(vos).map(v -> {return v.getPrimaryKey();}).collect(Collectors.toList());
			listpks.addAll(pks);
			vos = dao.listByCondition(Region_CjmMasterVO.class,  "pid in (" + inSQLCreator.getInSQL(pks.toArray(new String[0])) +")");
		}
		return listpks.toArray(new String[0]);
	}

	/**
	 * 获取 where 组织条件
	 * @return
	 */
	private String getPermOrg(String appcode) throws BusinessException {

		//获取 集团和组织条件
		String pkGroup = AppContext.getInstance().getPkGroup();
		String pkUser = AppContext.getInstance().getPkUser();

		//调用用户权限接口
		String[] orgs = NCLocator.getInstance().lookup(IAppAndOrgPermQueryPubService.class).queryUserPermOrgPksByApp(pkUser,appcode, pkGroup);

		return inSQLCreator.getInSQL(orgs);
	}

}
