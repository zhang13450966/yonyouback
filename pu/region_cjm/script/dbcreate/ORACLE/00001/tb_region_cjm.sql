 create table PU_REGION_CJMMASTER (def20 varchar2(101) null /*自定义项20*/,
def19 varchar2(101) null /*自定义项19*/,
def18 varchar2(101) null /*自定义项18*/,
def17 varchar2(101) null /*自定义项17*/,
def16 varchar2(101) null /*自定义项16*/,
def15 varchar2(101) null /*自定义项15*/,
def14 varchar2(101) null /*自定义项14*/,
def13 varchar2(101) null /*自定义项13*/,
def12 varchar2(101) null /*自定义项12*/,
def11 varchar2(101) null /*自定义项11*/,
def10 varchar2(101) null /*自定义项10*/,
def9 varchar2(101) null /*自定义项9*/,
def8 varchar2(101) null /*自定义项8*/,
def7 varchar2(101) null /*自定义项7*/,
def6 varchar2(101) null /*自定义项6*/,
def5 varchar2(101) null /*自定义项5*/,
def4 varchar2(101) null /*自定义项4*/,
def3 varchar2(101) null /*自定义项3*/,
def2 varchar2(101) null /*自定义项2*/,
def1 varchar2(101) null /*自定义项1*/,
modifiedtime char(19) null /*最后修改时间*/,
modifier varchar2(20) null /*最后修改人*/,
creationtime char(19) null /*创建时间*/,
creator varchar2(20) null /*创建人*/,
enablestate integer null /*启用状态*/,
pid varchar2(20) null /*上级*/,
name varchar2(50) null /*大区名称*/,
code varchar2(50) null /*大区编码*/,
pk_group varchar2(20) null /*集团*/,
pk_org varchar2(20) null /*组织*/,
pk_region_cjmmaster char(20) not null /*主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint PU_REGION_CJMMASTER_PK  primary key (pk_region_cjmmaster)
)

/

