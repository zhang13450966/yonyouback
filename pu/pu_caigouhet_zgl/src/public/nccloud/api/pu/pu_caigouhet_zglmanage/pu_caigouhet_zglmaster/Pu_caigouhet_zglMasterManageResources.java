
package nccloud.api.pu.pu_caigouhet_zglmanage.pu_caigouhet_zglmaster;

import java.lang.reflect.Field;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;

import org.json.JSONString;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import nccloud.ws.rest.resource.AbstractNCCRestResource;
import nccloud.api.rest.utils.ResultMessageUtil;
import nccloud.commons.lang.ArrayUtils;
import nccloud.commons.lang.StringUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pub.JavaType;
import nc.vo.pub.IAttributeMeta;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.lang.UFLiteralDate;
import nc.vo.pub.lang.UFTime;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglSlave0VO;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;

@Path("pu/pu_caigouhet_zglmanage/pu_caigouhet_zglMaster")
public class Pu_caigouhet_zglMasterManageResources extends AbstractNCCRestResource {

	private Map<String, String> fieldsNameAndType = new HashMap<>();

	private Map<String, Map<String, String>> bodyFieldsNameAndTypes = new HashMap<>();

	@Override
	public String getModule() {
		return "pu";
	}
	
	@POST
	@Path("/addAggPu_caigouhet_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString addAggPu_caigouhet_zglMasterVO(JSONString json) {
		return dealJson(json, "addAggPu_caigouhet_zglMasterVO");
	}
	
	@POST
	@Path("/deleteAggPu_caigouhet_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString deleteAggPu_caigouhet_zglMasterVO(JSONString json) {
		return dealJson(json, "deleteAggPu_caigouhet_zglMasterVO");
	}
	
	@POST
	@Path("/updateAggPu_caigouhet_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString updateAggPu_caigouhet_zglMasterVO(JSONString json) {
		return dealJson(json, "updateAggPu_caigouhet_zglMasterVO");
	}
	
	@POST
	@Path("/queryAggPu_caigouhet_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString queryAggPu_caigouhet_zglMasterVO(JSONString json) {
		return dealJson(json, "queryAggPu_caigouhet_zglMasterVO");
	}
	
	private JSONString dealJson(JSONString json, String methodName) {
		if(json == null) {
			return ResultMessageUtil.exceptionToJSON(new NullPointerException("输入参数不能为空！"));
		}
		JSONObject obj = JSON.parseObject(json.toJSONString());
		if(methodName.indexOf("add") >= 0) {
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String addError = "新增时必输项存在空值，为空的必输项有：" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(addError));
			} else {
				// 调用接口新增
				AggPu_caigouhet_zglMasterVO vo = buildVO(obj, true);
				AggPu_caigouhet_zglMasterVO[] result = null;
				try{
					result = getService().saveAggPu_caigouhet_zglMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				JSONObject returnJson = new JSONObject();
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}				
		} else if(methodName.indexOf("delete") >= 0) {
			String entityPk = obj.getString("pk_caigouhet_zglmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("删除时主键为必输项，不能为空！"));
			}
			// 删除需要区分全局、集团和业务单元
			String pk_org = obj.getString("pk_org");
			// 如果没有传pk_org, 默认是全局
			if(StringUtils.isEmpty(pk_org)) {
				pk_org = "GLOBLE00000000000000";
			}
			// 调用接口删除
			JSONObject returnJson = new JSONObject();
			Map<String, String> tsMap = new HashMap<>();
			Pu_caigouhet_zglMasterVO[] vos = null;
			try {
			vos = getService().listPu_caigouhet_zglMasterVOByPk(entityPk);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			if(ArrayUtils.isNotEmpty(vos)) {
				tsMap.put(vos[0].getAttributeValue("pk_caigouhet_zglmaster").toString(), vos[0].getTs().toString());
			}
			AggPu_caigouhet_zglMasterVO[] result = null;
			try {
				result = getService().deleteAggPu_caigouhet_zglMasterVOs(tsMap);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			returnJson.put("result", result);
			return ResultMessageUtil.toJSON(returnJson);
		} else if(methodName.indexOf("update") >= 0) {
			JSONObject object = (JSONObject)obj.get("pu_caigouhet_zglMaster");
			String entityPk = object.getString("pk_caigouhet_zglmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("修改时主键为必输项，不能为空！"));
			}
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String updateError = "修改时必输项存在空值，为空的必输项有：" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(updateError));
			} else {
				// 调用接口修改
				AggPu_caigouhet_zglMasterVO vo = buildVO(obj, false);
				AggPu_caigouhet_zglMasterVO[] result = null;
				JSONObject returnJson = new JSONObject();
				try{
					result = getService().saveAggPu_caigouhet_zglMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}		
		} else if(methodName.indexOf("query") >= 0) {
			// 查询时需要接收业务单元作为参数吗？
			StringBuilder sqlBuilder = new StringBuilder(" isnull(dr, 0) = 0");
			Set<Entry<String, Object>> entrySet = obj.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if(entry.getValue() != null) {
					sqlBuilder.append(" and " + entry.getKey() + "='" + entry.getValue() + "'");
				}
			}
			AggPu_caigouhet_zglMasterVO[] results = null;
			try {
			results = getService().listAggPu_caigouhet_zglMasterVOByCondition(sqlBuilder.toString());
			} catch (BusinessException e) {
				return ResultMessageUtil.exceptionToJSON(e);
			}
			JSONObject returnJson = new JSONObject();
			returnJson.put("result", results);
			return ResultMessageUtil.toJSON(returnJson);
		}
		return null;
	}
	
	private StringBuilder requiredFieldsValidate(JSONObject obj) {
		StringBuilder builder = new StringBuilder();
		List<String> notNullFields = getRequiredFields(obj);
		JSONObject object = (JSONObject)obj.get("pu_caigouhet_zglMaster");
		for(String notNullField : notNullFields) {
			Object val = object.get(notNullField);
			if(val == null){
				builder.append(notNullField + ",");
			}
		}
		return builder;
	}

	private AggPu_caigouhet_zglMasterVO buildVO(JSONObject json, boolean isAdd) {
		if(json.get("pu_caigouhet_zglMaster") == null) {
			throw new NullPointerException("传入参数中不存在主实体数据！");
		}
		int voStatus = isAdd ? VOStatus.NEW : VOStatus.UPDATED;
		AggPu_caigouhet_zglMasterVO aggVO = new AggPu_caigouhet_zglMasterVO();

		// 主实体
		JSONObject headJson = (JSONObject) json.get("pu_caigouhet_zglMaster");
		Pu_caigouhet_zglMasterVO headVO = new Pu_caigouhet_zglMasterVO();
		IAttributeMeta[] headAttrs = headVO.getMetaData().getAttributes();
		for (IAttributeMeta attribute : headAttrs) {
			Object value = getValueByAttr(headJson, attribute);
			headVO.setAttributeValue(attribute.getName(), value);
		}
		headVO.setStatus(voStatus);
		aggVO.setParent(headVO);

		// 子实体
		JSONArray pu_caigouhet_zglSlave0VOArr = json.getJSONArray("caigouhet_zglslave0_pu_caigouhet_zglslave0");
		if (pu_caigouhet_zglSlave0VOArr != null && !pu_caigouhet_zglSlave0VOArr.isEmpty()) {
			Pu_caigouhet_zglSlave0VO[] pu_caigouhet_zglSlave0VOs = new Pu_caigouhet_zglSlave0VO[pu_caigouhet_zglSlave0VOArr.size()];
			IAttributeMeta[] bodyAttrs = new Pu_caigouhet_zglSlave0VO().getMetaData().getAttributes();
			for (int i = 0; i < pu_caigouhet_zglSlave0VOArr.size(); i++) {
				JSONObject pu_caigouhet_zglSlave0VOJson = (JSONObject) pu_caigouhet_zglSlave0VOArr.get(i);
				pu_caigouhet_zglSlave0VOs[i] = new Pu_caigouhet_zglSlave0VO();
				for (IAttributeMeta attribute : bodyAttrs) {
					Object value = getValueByAttr(pu_caigouhet_zglSlave0VOJson, attribute);
					pu_caigouhet_zglSlave0VOs[i].setAttributeValue(attribute.getName(), value);
				}
				pu_caigouhet_zglSlave0VOs[i].setStatus(voStatus);

			}
			aggVO.setChildren(Pu_caigouhet_zglSlave0VO.class, pu_caigouhet_zglSlave0VOs);
		}
		return aggVO;
	}

	private Object getValueByAttr(JSONObject json, IAttributeMeta attribute) {
		Object value = json.get(attribute.getName());
		if (value == null || StringUtils.isEmpty(value.toString())) {
			return null;
		}
		JavaType javaType = attribute.getJavaType();
		switch (javaType) {
			case String:
			case UFStringEnum:
				return value.toString();
			case BigDecimal:
				return new BigDecimal(value.toString());
			case Integer:
			case UFFlag:
				return Integer.valueOf(value.toString());
			case UFDouble:
				return new UFDouble(value.toString());
			case UFBoolean:
				return new UFBoolean(value.toString());
			case UFDate:
				return new UFDate(value.toString());
			case UFDateTime:
				return new UFDateTime(value.toString());
			case UFTime:
				return new UFTime(value.toString());
			case UFLiteralDate:
				return new UFLiteralDate(value.toString());
			default:
				return value;
		}
	}

	private List<String> getRequiredFields(JSONObject obj) {
		List<String> notNullFields = new ArrayList<String>();
		return notNullFields;
	}
	
	private IPu_caigouhet_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(IPu_caigouhet_zglMasterVOService.class);
	}
	
}

