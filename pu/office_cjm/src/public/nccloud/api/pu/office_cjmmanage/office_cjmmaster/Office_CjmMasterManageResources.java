
package nccloud.api.pu.office_cjmmanage.office_cjmmaster;

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
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;

@Path("pu/office_cjmmanage/office_CjmMaster")
public class Office_CjmMasterManageResources extends AbstractNCCRestResource {

	private Map<String, String> fieldsNameAndType = new HashMap<>();

	private Map<String, Map<String, String>> bodyFieldsNameAndTypes = new HashMap<>();

	@Override
	public String getModule() {
		return "pu";
	}
	
	@POST
	@Path("/addOffice_CjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString addOffice_CjmMasterVO(JSONString json) {
		return dealJson(json, "addOffice_CjmMasterVO");
	}
	
	@POST
	@Path("/deleteOffice_CjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString deleteOffice_CjmMasterVO(JSONString json) {
		return dealJson(json, "deleteOffice_CjmMasterVO");
	}
	
	@POST
	@Path("/updateOffice_CjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString updateOffice_CjmMasterVO(JSONString json) {
		return dealJson(json, "updateOffice_CjmMasterVO");
	}
	
	@POST
	@Path("/queryOffice_CjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString queryOffice_CjmMasterVO(JSONString json) {
		return dealJson(json, "queryOffice_CjmMasterVO");
	}
	
	private JSONString dealJson(JSONString json, String methodName) {
		if(json == null) {
			return ResultMessageUtil.exceptionToJSON(new NullPointerException("�����������Ϊ�գ�"));
		}
		JSONObject obj = JSON.parseObject(json.toJSONString());
		if(methodName.indexOf("add") >= 0) {
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String addError = "����ʱ��������ڿ�ֵ��Ϊ�յı������У�" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(addError));
			} else {
				// ���ýӿ�����
				Office_CjmMasterVO vo = buildVO(obj, true);
				Office_CjmMasterVO[] result = null;
				try{
					result = getService().saveOffice_CjmMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				JSONObject returnJson = new JSONObject();
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}				
		} else if(methodName.indexOf("delete") >= 0) {
			String entityPk = obj.getString("pk_office_cjmmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("ɾ��ʱ����Ϊ���������Ϊ�գ�"));
			}
			// ɾ����Ҫ����ȫ�֡����ź�ҵ��Ԫ
			String pk_org = obj.getString("pk_org");
			// ���û�д�pk_org, Ĭ����ȫ��
			if(StringUtils.isEmpty(pk_org)) {
				pk_org = "GLOBLE00000000000000";
			}
			// ���ýӿ�ɾ��
			JSONObject returnJson = new JSONObject();
			Map<String, String> tsMap = new HashMap<>();
			Office_CjmMasterVO[] vos = null;
			try {
			vos = getService().listOffice_CjmMasterVOByPk("pk_office_cjmmaster = '" + entityPk + "'", false);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			if(ArrayUtils.isNotEmpty(vos)) {
				tsMap.put(vos[0].getAttributeValue("pk_office_cjmmaster").toString(), vos[0].getTs().toString());
			}
			Office_CjmMasterVO[] result = null;
			try {
				result = getService().deleteOffice_CjmMasterVOs(tsMap);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			returnJson.put("result", result);
			return ResultMessageUtil.toJSON(returnJson);
		} else if(methodName.indexOf("update") >= 0) {
			JSONObject object = (JSONObject)obj.get("office_CjmMaster");
			String entityPk = object.getString("pk_office_cjmmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("�޸�ʱ����Ϊ���������Ϊ�գ�"));
			}
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String updateError = "�޸�ʱ��������ڿ�ֵ��Ϊ�յı������У�" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(updateError));
			} else {
				// ���ýӿ��޸�
				Office_CjmMasterVO vo = buildVO(obj, false);
				Office_CjmMasterVO[] result = null;
				JSONObject returnJson = new JSONObject();
				try{
					result = getService().saveOffice_CjmMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}		
		} else if(methodName.indexOf("query") >= 0) {
			// ��ѯʱ��Ҫ����ҵ��Ԫ��Ϊ������
			StringBuilder sqlBuilder = new StringBuilder(" isnull(dr, 0) = 0");
			Set<Entry<String, Object>> entrySet = obj.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if(entry.getValue() != null) {
					sqlBuilder.append(" and " + entry.getKey() + "='" + entry.getValue() + "'");
				}
			}
			Office_CjmMasterVO[] results = null;
			try {
			String[] pks = getService().listOffice_CjmMasterVOPkByCond(sqlBuilder.toString());
			results = getService().listOffice_CjmMasterVOByPk(pks, false);
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
		JSONObject object = (JSONObject)obj.get("office_CjmMaster");
		for(String notNullField : notNullFields) {
			Object val = object.get(notNullField);
			if(val == null){
				builder.append(notNullField + ",");
			}
		}
		return builder;
	}

	private Office_CjmMasterVO buildVO(JSONObject json, boolean isAdd) {
		if(json.get("office_CjmMaster") == null) {
			throw new NullPointerException("��������в�������ʵ�����ݣ�");
		}
		int voStatus = isAdd ? VOStatus.NEW : VOStatus.UPDATED;

		// ��ʵ��
		JSONObject headJson = (JSONObject) json.get("office_CjmMaster");
		Office_CjmMasterVO headVO = new Office_CjmMasterVO();
		IAttributeMeta[] headAttrs = headVO.getMetaData().getAttributes();
		for (IAttributeMeta attribute : headAttrs) {
			Object value = getValueByAttr(headJson, attribute);
			headVO.setAttributeValue(attribute.getName(), value);
		}
		headVO.setStatus(voStatus);

		return headVO;
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
	
	private IOffice_CjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOffice_CjmMasterVOService.class);
	}
	
}

