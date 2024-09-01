 create table UAPBD_TESTMDSLAVE0 (srcrowno varchar2(50) null /*来源行号*/,
rowno varchar2(50) null /*行号*/,
pk_testmdslave0 char(20) not null /*主键*/,
pk_testmdmaster char(20) not null /*上层单据主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint UAPBD_TESTMDSLAVE0_PK  primary key (pk_testmdslave0)
)

/

 create table UAPBD_TESTMDMASTER (saga_status integer null /*事务状态*/,
saga_btxid varchar2(64) null /*分支事务id*/,
saga_gtxid varchar2(64) null /*全局事务id*/,
saga_frozen integer null /*冻结状态*/,
srcbilltype varchar2(50) null /*来源单据类型*/,
srcbillid varchar2(50) null /*来源单据id*/,
busitype varchar2(20) null /*业务类型*/,
billmaker varchar2(20) null /*制单人*/,
emendenum integer null /*修订枚举*/,
approvestatus char(20) null /*审批状态*/,
approvedate char(19) null /*审批时间*/,
approver varchar2(20) null /*审批人*/,
approvenote varchar2(50) null /*审批批语*/,
transtypepk varchar2(20) null /*交易类型pk*/,
transtype varchar2(50) null /*交易类型*/,
billtype varchar2(50) null /*单据类型*/,
billversionpk varchar2(50) null /*单据版本pk*/,
lastmaketime char(19) null /*最后修改时间1*/,
maketime char(19) null /*制单时间*/,
pk_org_v varchar2(20) null /*组织多版本*/,
modifiedtime char(19) null /*最后修改时间*/,
modifier varchar2(20) null /*最后修改人*/,
creationtime char(19) null /*创建时间*/,
creator varchar2(20) null /*创建人*/,
name varchar2(50) null /*name*/,
code varchar2(50) null /*code*/,
pk_group varchar2(20) null /*pk_group*/,
pk_org varchar2(20) null /*pk_org*/,
pk_testmdmaster char(20) not null /*主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint UAPBD_TESTMDMASTER_PK  primary key (pk_testmdmaster)
)

/

