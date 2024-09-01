 create table UAPBD_PATIENTMASTER (modifiedtime char(19) null /*最后修改时间*/,
modifier varchar2(20) null /*最后修改人*/,
creationtime char(19) null /*创建时间*/,
creator varchar2(20) null /*创建人*/,
admission integer null /*住院次数*/,
medicalno varchar2(50) null /*病历号*/,
vdeptcode varchar2(50) null /*科室编码*/,
vdeptname varchar2(50) null /*科室名称*/,
vcardid varchar2(50) null /*身份证号*/,
name varchar2(50) null /*name*/,
code varchar2(50) null /*code*/,
pk_group varchar2(20) null /*pk_group*/,
pk_org varchar2(20) null /*pk_org*/,
pk_patientmaster char(20) not null /*主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint UAPBD_PATIENTMASTER_PK  primary key (pk_patientmaster)
)

/

