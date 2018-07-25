package com.example.tuosha.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SWbean implements Serializable {
    private static final long serialVersionUID = 1L;

    private byte command;
    private byte recommand;
    private int result;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String vcode;

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getEx_Data() {
        return Ex_Data;
    }

    public void setEx_Data(String ex_Data) {
        Ex_Data = ex_Data;
    }

    private String Ex_Data;

    private TbAdminEntity tbAdminEntity;
    private TbLogEntity tbLogEntity; //
    private TbUsersEntity tbUsersEntity;
//    private ImsXuanMixloanBankCardEntity bankCardEntity;
//    private ImsXuanMixloanBankEntity bankEntity;
//    private ImsXuanMixloanChannelEntity channelEntity;
//    private ImsXuanMixloanChannelSubjectEntity channelSubjectEntity;
//    private ImsXuanMixloanCreditcardEntity creditcardEntity;
//    private ImsXuanMixloanHelpEntity helpEntity;
//    private ImsXuanMixloanLoanEntity loanEntity;
//    private ImsXuanMixloanInviterEntity inviterEntity;
//    private ImsXuanMixloanMemberEntity memberEntity;
//    private ImsXuanMixloanPaymentEntity paymentEntity;
//    private ImsXuanMixloanPosterEntity posterEntity;
//    private ImsXuanMixloanProductApplyEntity productApplyEntity;
//    private ImsXuanMixloanProductEntity productEntity;

//    private  ArrayList<TbAdminEntity> tbAdminList;
//    private  ArrayList<TbLogEntity> tbLogList; //
//    private  ArrayList<TbUsersEntity> tbUsersList;
//    private  ArrayList<ImsXuanMixloanBankCardEntity> bankCardList;
//    private  ArrayList<ImsXuanMixloanBankEntity> bankList;
//    private ArrayList<ImsXuanMixloanBankEntity> ImsXuanMixloanBankEntity;
//    private ArrayList<ImsXuanMixloanChannelEntity> channelList;
//    private ArrayList<ImsXuanMixloanChannelSubjectEntity> channelSubjectList;
//    private ArrayList<ImsXuanMixloanCreditcardEntity> creditcardList;
//    private ArrayList<ImsXuanMixloanHelpEntity> helpList;
//    private ArrayList<ImsXuanMixloanLoanEntity> loanList;
//    private ArrayList<ImsXuanMixloanInviterEntity> inviterList;
//    private ArrayList<ImsXuanMixloanMemberEntity> memberList;
//    private ArrayList<ImsXuanMixloanPaymentEntity> paymentList;
//    private ArrayList<ImsXuanMixloanPosterEntity> posterList;
//    private ArrayList<ImsXuanMixloanProductApplyEntity> productApplyList;
//    private ArrayList<ImsXuanMixloanProductEntity> productList;
    //新加表
    private AlipayEntity alipayEntity;
    private BankCardsEntity bankCardsEntity;
    private CategoriesEntity categoriesEntity;
    private DaikuansEntity daikuansEntity;
    private EDusEntity eDusEntity;
    private HkjBannersEntity hkjBannersEntity;
    private HkjsEntity hkjsEntity;
    private JieQianBannersEntity jieQianBannersEntity;
    private JieQianJqCatEntity jieQianJqCatEntity;
    private JieQiansEntity jieQiansEntity;
    private JqCatsEntity jqCatsEntity;
    private MigrationsEntity migrationsEntity;
    private MobileversionEntity mobileversionEntity;
    private MoneyRecordsEntity moneyRecordsEntity;
    private NoticesEntity noticesEntity;
    private OrdersEntity ordersEntity;
    private PasswordResetsEntity passwordResetsEntity;
    private PostsEntity postsEntity;
    private ProcessesEntity processesEntity;
    private ProductsEntity productsEntity;
    private SettingsEntity settingsEntity;
    private TiEsEntity tiEsEntity ;
    private  ToolsEntity toolsEntity;
    private  UsersEntity usersEntity;
    private  XinYongKasEntity xinYongKasEntity;
    private  XykBannersEntity xykBannersEntity;


    private  ArrayList<AlipayEntity> alipayEntities; //
    private  ArrayList<BankCardsEntity> bankCardsEntities; //
    private  ArrayList<CategoriesEntity> categoriesEntities; //
    private  ArrayList<DaikuansEntity> daikuansEntities;
    private  ArrayList<EDusEntity> eDusEntities; //
    private  ArrayList<HkjBannersEntity> hkjBannersEntities; //
    private  ArrayList<HkjsEntity> hkjsEntities;
    private  ArrayList<JieQianBannersEntity> jieQianBannersEntities; //
    private  ArrayList<JieQianJqCatEntity> jieQianJqCatEntities;
    private  ArrayList<JieQiansEntity> jieQiansEntities;
    private  ArrayList<JqCatsEntity> jqCatsEntities;
    private  ArrayList<MigrationsEntity> migrationsEntities;
    private  ArrayList<MobileversionEntity> mobileversionEntities;
    private  ArrayList<MoneyRecordsEntity> moneyRecordsEntities;
    private  ArrayList<NoticesEntity> noticesEntities;
    private  ArrayList<OrdersEntity> ordersEntities;
    private  ArrayList<PasswordResetsEntity> passwordResetsEntities;
    private  ArrayList<PostsEntity> postsEntities;
    private  ArrayList<ProcessesEntity> processesEntities;
    private  ArrayList<ProductsEntity> productsEntities;
    private  ArrayList<SettingsEntity> settingsEntities;
    private  ArrayList<TiEsEntity> tiEsEntities;
    private  ArrayList<ToolsEntity> toolsEntities;
    private  ArrayList<UsersEntity> usersEntities;
    private  ArrayList<XinYongKasEntity> xinYongKasEntities;
    private  ArrayList<XykBannersEntity> xykBannersEntities;




    private int KouziType;
    private int JisuType;

    public int getJisuType() {
        return JisuType;
    }

    public void setJisuType(int jisuType) {
        JisuType = jisuType;
    }

    private ArrayList<KouziBean> KouziBean;
    private ArrayList<ContentBean> ContentBean;

    public ArrayList<com.example.tuosha.model.ContentBean> getContentBean() {
        return ContentBean;
    }

    public void setContentBean(ArrayList<com.example.tuosha.model.ContentBean> contentBean) {
        ContentBean = contentBean;
    }

    public ArrayList<com.example.tuosha.model.KouziBean> getKouziBean() {
        return KouziBean;
    }

    public void setKouziBean(ArrayList<com.example.tuosha.model.KouziBean> kouziBean) {
        KouziBean = kouziBean;
    }

    public int getKouziType() {
        return KouziType;
    }

    public void setKouziType(int kouziType) {
        KouziType = kouziType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte getCommand() {
        return command;
    }

    public void setCommand(byte command) {
        this.command = command;
    }

    public byte getRecommand() {
        return recommand;
    }

    public void setRecommand(byte recommand) {
        this.recommand = recommand;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public TbAdminEntity getTbAdminEntity() {
        return tbAdminEntity;
    }

    public void setTbAdminEntity(TbAdminEntity tbAdminEntity) {
        this.tbAdminEntity = tbAdminEntity;
    }

    public TbLogEntity getTbLogEntity() {
        return tbLogEntity;
    }

    public void setTbLogEntity(TbLogEntity tbLogEntity) {
        this.tbLogEntity = tbLogEntity;
    }

    public TbUsersEntity getTbUsersEntity() {
        return tbUsersEntity;
    }

    public void setTbUsersEntity(TbUsersEntity tbUsersEntity) {
        this.tbUsersEntity = tbUsersEntity;
    }

    public AlipayEntity getAlipayEntity() {
        return alipayEntity;
    }

    public void setAlipayEntity(AlipayEntity alipayEntity) {
        this.alipayEntity = alipayEntity;
    }

    public BankCardsEntity getBankCardsEntity() {
        return bankCardsEntity;
    }

    public void setBankCardsEntity(BankCardsEntity bankCardsEntity) {
        this.bankCardsEntity = bankCardsEntity;
    }

    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }

    public DaikuansEntity getDaikuansEntity() {
        return daikuansEntity;
    }

    public void setDaikuansEntity(DaikuansEntity daikuansEntity) {
        this.daikuansEntity = daikuansEntity;
    }

    public EDusEntity geteDusEntity() {
        return eDusEntity;
    }

    public void seteDusEntity(EDusEntity eDusEntity) {
        this.eDusEntity = eDusEntity;
    }

    public HkjBannersEntity getHkjBannersEntity() {
        return hkjBannersEntity;
    }

    public void setHkjBannersEntity(HkjBannersEntity hkjBannersEntity) {
        this.hkjBannersEntity = hkjBannersEntity;
    }

    public HkjsEntity getHkjsEntity() {
        return hkjsEntity;
    }

    public void setHkjsEntity(HkjsEntity hkjsEntity) {
        this.hkjsEntity = hkjsEntity;
    }

    public JieQianBannersEntity getJieQianBannersEntity() {
        return jieQianBannersEntity;
    }

    public void setJieQianBannersEntity(JieQianBannersEntity jieQianBannersEntity) {
        this.jieQianBannersEntity = jieQianBannersEntity;
    }

    public JieQianJqCatEntity getJieQianJqCatEntity() {
        return jieQianJqCatEntity;
    }

    public void setJieQianJqCatEntity(JieQianJqCatEntity jieQianJqCatEntity) {
        this.jieQianJqCatEntity = jieQianJqCatEntity;
    }

    public JieQiansEntity getJieQiansEntity() {
        return jieQiansEntity;
    }

    public void setJieQiansEntity(JieQiansEntity jieQiansEntity) {
        this.jieQiansEntity = jieQiansEntity;
    }

    public JqCatsEntity getJqCatsEntity() {
        return jqCatsEntity;
    }

    public void setJqCatsEntity(JqCatsEntity jqCatsEntity) {
        this.jqCatsEntity = jqCatsEntity;
    }

    public MigrationsEntity getMigrationsEntity() {
        return migrationsEntity;
    }

    public void setMigrationsEntity(MigrationsEntity migrationsEntity) {
        this.migrationsEntity = migrationsEntity;
    }

    public MobileversionEntity getMobileversionEntity() {
        return mobileversionEntity;
    }

    public void setMobileversionEntity(MobileversionEntity mobileversionEntity) {
        this.mobileversionEntity = mobileversionEntity;
    }

    public MoneyRecordsEntity getMoneyRecordsEntity() {
        return moneyRecordsEntity;
    }

    public void setMoneyRecordsEntity(MoneyRecordsEntity moneyRecordsEntity) {
        this.moneyRecordsEntity = moneyRecordsEntity;
    }

    public NoticesEntity getNoticesEntity() {
        return noticesEntity;
    }

    public void setNoticesEntity(NoticesEntity noticesEntity) {
        this.noticesEntity = noticesEntity;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    public PasswordResetsEntity getPasswordResetsEntity() {
        return passwordResetsEntity;
    }

    public void setPasswordResetsEntity(PasswordResetsEntity passwordResetsEntity) {
        this.passwordResetsEntity = passwordResetsEntity;
    }

    public PostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(PostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }

    public ProcessesEntity getProcessesEntity() {
        return processesEntity;
    }

    public void setProcessesEntity(ProcessesEntity processesEntity) {
        this.processesEntity = processesEntity;
    }

    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    public SettingsEntity getSettingsEntity() {
        return settingsEntity;
    }

    public void setSettingsEntity(SettingsEntity settingsEntity) {
        this.settingsEntity = settingsEntity;
    }

    public TiEsEntity getTiEsEntity() {
        return tiEsEntity;
    }

    public void setTiEsEntity(TiEsEntity tiEsEntity) {
        this.tiEsEntity = tiEsEntity;
    }

    public ToolsEntity getToolsEntity() {
        return toolsEntity;
    }

    public void setToolsEntity(ToolsEntity toolsEntity) {
        this.toolsEntity = toolsEntity;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public XinYongKasEntity getXinYongKasEntity() {
        return xinYongKasEntity;
    }

    public void setXinYongKasEntity(XinYongKasEntity xinYongKasEntity) {
        this.xinYongKasEntity = xinYongKasEntity;
    }

    public XykBannersEntity getXykBannersEntity() {
        return xykBannersEntity;
    }

    public void setXykBannersEntity(XykBannersEntity xykBannersEntity) {
        this.xykBannersEntity = xykBannersEntity;
    }

    public ArrayList<AlipayEntity> getAlipayEntities() {
        return alipayEntities;
    }

    public void setAlipayEntities(ArrayList<AlipayEntity> alipayEntities) {
        this.alipayEntities = alipayEntities;
    }

    public ArrayList<BankCardsEntity> getBankCardsEntities() {
        return bankCardsEntities;
    }

    public void setBankCardsEntities(ArrayList<BankCardsEntity> bankCardsEntities) {
        this.bankCardsEntities = bankCardsEntities;
    }

    public ArrayList<CategoriesEntity> getCategoriesEntities() {
        return categoriesEntities;
    }

    public void setCategoriesEntities(ArrayList<CategoriesEntity> categoriesEntities) {
        this.categoriesEntities = categoriesEntities;
    }

    public ArrayList<DaikuansEntity> getDaikuansEntities() {
        return daikuansEntities;
    }

    public void setDaikuansEntities(ArrayList<DaikuansEntity> daikuansEntities) {
        this.daikuansEntities = daikuansEntities;
    }

    public ArrayList<EDusEntity> geteDusEntities() {
        return eDusEntities;
    }

    public void seteDusEntities(ArrayList<EDusEntity> eDusEntities) {
        this.eDusEntities = eDusEntities;
    }

    public ArrayList<HkjBannersEntity> getHkjBannersEntities() {
        return hkjBannersEntities;
    }

    public void setHkjBannersEntities(ArrayList<HkjBannersEntity> hkjBannersEntities) {
        this.hkjBannersEntities = hkjBannersEntities;
    }

    public ArrayList<HkjsEntity> getHkjsEntities() {
        return hkjsEntities;
    }

    public void setHkjsEntities(ArrayList<HkjsEntity> hkjsEntities) {
        this.hkjsEntities = hkjsEntities;
    }

    public ArrayList<JieQianBannersEntity> getJieQianBannersEntities() {
        return jieQianBannersEntities;
    }

    public void setJieQianBannersEntities(ArrayList<JieQianBannersEntity> jieQianBannersEntities) {
        this.jieQianBannersEntities = jieQianBannersEntities;
    }

    public ArrayList<JieQianJqCatEntity> getJieQianJqCatEntities() {
        return jieQianJqCatEntities;
    }

    public void setJieQianJqCatEntities(ArrayList<JieQianJqCatEntity> jieQianJqCatEntities) {
        this.jieQianJqCatEntities = jieQianJqCatEntities;
    }

    public ArrayList<JieQiansEntity> getJieQiansEntities() {
        return jieQiansEntities;
    }

    public void setJieQiansEntities(ArrayList<JieQiansEntity> jieQiansEntities) {
        this.jieQiansEntities = jieQiansEntities;
    }

    public ArrayList<JqCatsEntity> getJqCatsEntities() {
        return jqCatsEntities;
    }

    public void setJqCatsEntities(ArrayList<JqCatsEntity> jqCatsEntities) {
        this.jqCatsEntities = jqCatsEntities;
    }

    public ArrayList<MigrationsEntity> getMigrationsEntities() {
        return migrationsEntities;
    }

    public void setMigrationsEntities(ArrayList<MigrationsEntity> migrationsEntities) {
        this.migrationsEntities = migrationsEntities;
    }

    public ArrayList<MobileversionEntity> getMobileversionEntities() {
        return mobileversionEntities;
    }

    public void setMobileversionEntities(ArrayList<MobileversionEntity> mobileversionEntities) {
        this.mobileversionEntities = mobileversionEntities;
    }

    public ArrayList<MoneyRecordsEntity> getMoneyRecordsEntities() {
        return moneyRecordsEntities;
    }

    public void setMoneyRecordsEntities(ArrayList<MoneyRecordsEntity> moneyRecordsEntities) {
        this.moneyRecordsEntities = moneyRecordsEntities;
    }

    public ArrayList<NoticesEntity> getNoticesEntities() {
        return noticesEntities;
    }

    public void setNoticesEntities(ArrayList<NoticesEntity> noticesEntities) {
        this.noticesEntities = noticesEntities;
    }

    public ArrayList<OrdersEntity> getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(ArrayList<OrdersEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }

    public ArrayList<PasswordResetsEntity> getPasswordResetsEntities() {
        return passwordResetsEntities;
    }

    public void setPasswordResetsEntities(ArrayList<PasswordResetsEntity> passwordResetsEntities) {
        this.passwordResetsEntities = passwordResetsEntities;
    }

    public ArrayList<PostsEntity> getPostsEntities() {
        return postsEntities;
    }

    public void setPostsEntities(ArrayList<PostsEntity> postsEntities) {
        this.postsEntities = postsEntities;
    }

    public ArrayList<ProcessesEntity> getProcessesEntities() {
        return processesEntities;
    }

    public void setProcessesEntities(ArrayList<ProcessesEntity> processesEntities) {
        this.processesEntities = processesEntities;
    }

    public ArrayList<ProductsEntity> getProductsEntities() {
        return productsEntities;
    }

    public void setProductsEntities(ArrayList<ProductsEntity> productsEntities) {
        this.productsEntities = productsEntities;
    }

    public ArrayList<SettingsEntity> getSettingsEntities() {
        return settingsEntities;
    }

    public void setSettingsEntities(ArrayList<SettingsEntity> settingsEntities) {
        this.settingsEntities = settingsEntities;
    }

    public ArrayList<TiEsEntity> getTiEsEntities() {
        return tiEsEntities;
    }

    public void setTiEsEntities(ArrayList<TiEsEntity> tiEsEntities) {
        this.tiEsEntities = tiEsEntities;
    }

    public ArrayList<ToolsEntity> getToolsEntities() {
        return toolsEntities;
    }

    public void setToolsEntities(ArrayList<ToolsEntity> toolsEntities) {
        this.toolsEntities = toolsEntities;
    }

    public ArrayList<UsersEntity> getUsersEntities() {
        return usersEntities;
    }

    public void setUsersEntities(ArrayList<UsersEntity> usersEntities) {
        this.usersEntities = usersEntities;
    }

    public ArrayList<XinYongKasEntity> getXinYongKasEntities() {
        return xinYongKasEntities;
    }

    public void setXinYongKasEntities(ArrayList<XinYongKasEntity> xinYongKasEntities) {
        this.xinYongKasEntities = xinYongKasEntities;
    }

    public ArrayList<XykBannersEntity> getXykBannersEntities() {
        return xykBannersEntities;
    }

    public void setXykBannersEntities(ArrayList<XykBannersEntity> xykBannersEntities) {
        this.xykBannersEntities = xykBannersEntities;
    }

    //    public ImsXuanMixloanBankCardEntity getBankCardEntity() {
//        return bankCardEntity;
//    }
//
//    public void setBankCardEntity(ImsXuanMixloanBankCardEntity bankCardEntity) {
//        this.bankCardEntity = bankCardEntity;
//    }
//
//    public com.example.tuosha.model.ImsXuanMixloanBankEntity getBankEntity() {
//        return bankEntity;
//    }
//
//    public void setBankEntity(com.example.tuosha.model.ImsXuanMixloanBankEntity bankEntity) {
//        this.bankEntity = bankEntity;
//    }
//
//    public ImsXuanMixloanChannelEntity getChannelEntity() {
//        return channelEntity;
//    }
//
//    public void setChannelEntity(ImsXuanMixloanChannelEntity channelEntity) {
//        this.channelEntity = channelEntity;
//    }
//
//    public ImsXuanMixloanChannelSubjectEntity getChannelSubjectEntity() {
//        return channelSubjectEntity;
//    }
//
//    public void setChannelSubjectEntity(ImsXuanMixloanChannelSubjectEntity channelSubjectEntity) {
//        this.channelSubjectEntity = channelSubjectEntity;
//    }
//
//    public ImsXuanMixloanCreditcardEntity getCreditcardEntity() {
//        return creditcardEntity;
//    }
//
//    public void setCreditcardEntity(ImsXuanMixloanCreditcardEntity creditcardEntity) {
//        this.creditcardEntity = creditcardEntity;
//    }
//
//    public ImsXuanMixloanHelpEntity getHelpEntity() {
//        return helpEntity;
//    }
//
//    public void setHelpEntity(ImsXuanMixloanHelpEntity helpEntity) {
//        this.helpEntity = helpEntity;
//    }
//
//    public ImsXuanMixloanLoanEntity getLoanEntity() {
//        return loanEntity;
//    }
//
//    public void setLoanEntity(ImsXuanMixloanLoanEntity loanEntity) {
//        this.loanEntity = loanEntity;
//    }
//
//    public ImsXuanMixloanInviterEntity getInviterEntity() {
//        return inviterEntity;
//    }
//
//    public void setInviterEntity(ImsXuanMixloanInviterEntity inviterEntity) {
//        this.inviterEntity = inviterEntity;
//    }
//
//    public ImsXuanMixloanMemberEntity getMemberEntity() {
//        return memberEntity;
//    }
//
//    public void setMemberEntity(ImsXuanMixloanMemberEntity memberEntity) {
//        this.memberEntity = memberEntity;
//    }
//
//    public ImsXuanMixloanPaymentEntity getPaymentEntity() {
//        return paymentEntity;
//    }
//
//    public void setPaymentEntity(ImsXuanMixloanPaymentEntity paymentEntity) {
//        this.paymentEntity = paymentEntity;
//    }
//
//    public ImsXuanMixloanPosterEntity getPosterEntity() {
//        return posterEntity;
//    }
//
//    public void setPosterEntity(ImsXuanMixloanPosterEntity posterEntity) {
//        this.posterEntity = posterEntity;
//    }
//
//    public ImsXuanMixloanProductApplyEntity getProductApplyEntity() {
//        return productApplyEntity;
//    }
//
//    public void setProductApplyEntity(ImsXuanMixloanProductApplyEntity productApplyEntity) {
//        this.productApplyEntity = productApplyEntity;
//    }
//
//    public ImsXuanMixloanProductEntity getProductEntity() {
//        return productEntity;
//    }
//
//    public void setProductEntity(ImsXuanMixloanProductEntity productEntity) {
//        this.productEntity = productEntity;
//    }
//
//    public ArrayList<TbAdminEntity> getTbAdminList() {
//        return tbAdminList;
//    }
//
//    public void setTbAdminList(ArrayList<TbAdminEntity> tbAdminList) {
//        this.tbAdminList = tbAdminList;
//    }
//
//    public ArrayList<TbLogEntity> getTbLogList() {
//        return tbLogList;
//    }
//
//    public void setTbLogList(ArrayList<TbLogEntity> tbLogList) {
//        this.tbLogList = tbLogList;
//    }
//
//    public ArrayList<TbUsersEntity> getTbUsersList() {
//        return tbUsersList;
//    }
//
//    public void setTbUsersList(ArrayList<TbUsersEntity> tbUsersList) {
//        this.tbUsersList = tbUsersList;
//    }
//
//    public ArrayList<ImsXuanMixloanBankCardEntity> getBankCardList() {
//        return bankCardList;
//    }
//
//    public void setBankCardList(ArrayList<ImsXuanMixloanBankCardEntity> bankCardList) {
//        this.bankCardList = bankCardList;
//    }
//
//    public ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> getBankList() {
//        return bankList;
//    }
//
//    public void setBankList(ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> bankList) {
//        this.bankList = bankList;
//    }
//
//    public ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> getImsXuanMixloanBankEntity() {
//        return ImsXuanMixloanBankEntity;
//    }
//
//    public void setImsXuanMixloanBankEntity(ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> imsXuanMixloanBankEntity) {
//        ImsXuanMixloanBankEntity = imsXuanMixloanBankEntity;
//    }
//
//    public ArrayList<ImsXuanMixloanChannelEntity> getChannelList() {
//        return channelList;
//    }
//
//    public void setChannelList(ArrayList<ImsXuanMixloanChannelEntity> channelList) {
//        this.channelList = channelList;
//    }
//
//    public ArrayList<ImsXuanMixloanChannelSubjectEntity> getChannelSubjectList() {
//        return channelSubjectList;
//    }
//
//    public void setChannelSubjectList(ArrayList<ImsXuanMixloanChannelSubjectEntity> channelSubjectList) {
//        this.channelSubjectList = channelSubjectList;
//    }
//
//    public ArrayList<ImsXuanMixloanCreditcardEntity> getCreditcardList() {
//        return creditcardList;
//    }
//
//    public void setCreditcardList(ArrayList<ImsXuanMixloanCreditcardEntity> creditcardList) {
//        this.creditcardList = creditcardList;
//    }
//
//    public ArrayList<ImsXuanMixloanHelpEntity> getHelpList() {
//        return helpList;
//    }
//
//    public void setHelpList(ArrayList<ImsXuanMixloanHelpEntity> helpList) {
//        this.helpList = helpList;
//    }
//
//    public ArrayList<ImsXuanMixloanLoanEntity> getLoanList() {
//        return loanList;
//    }
//
//    public void setLoanList(ArrayList<ImsXuanMixloanLoanEntity> loanList) {
//        this.loanList = loanList;
//    }
//
//    public ArrayList<ImsXuanMixloanInviterEntity> getInviterList() {
//        return inviterList;
//    }
//
//    public void setInviterList(ArrayList<ImsXuanMixloanInviterEntity> inviterList) {
//        this.inviterList = inviterList;
//    }
//
//    public ArrayList<ImsXuanMixloanMemberEntity> getMemberList() {
//        return memberList;
//    }
//
//    public void setMemberList(ArrayList<ImsXuanMixloanMemberEntity> memberList) {
//        this.memberList = memberList;
//    }
//
//    public ArrayList<ImsXuanMixloanPaymentEntity> getPaymentList() {
//        return paymentList;
//    }
//
//    public void setPaymentList(ArrayList<ImsXuanMixloanPaymentEntity> paymentList) {
//        this.paymentList = paymentList;
//    }
//
//    public ArrayList<ImsXuanMixloanPosterEntity> getPosterList() {
//        return posterList;
//    }
//
//    public void setPosterList(ArrayList<ImsXuanMixloanPosterEntity> posterList) {
//        this.posterList = posterList;
//    }
//
//    public ArrayList<ImsXuanMixloanProductApplyEntity> getProductApplyList() {
//        return productApplyList;
//    }
//
//    public void setProductApplyList(ArrayList<ImsXuanMixloanProductApplyEntity> productApplyList) {
//        this.productApplyList = productApplyList;
//    }
//
//    public ArrayList<ImsXuanMixloanProductEntity> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(ArrayList<ImsXuanMixloanProductEntity> productList) {
//        this.productList = productList;
//    }

    @Override
    public String toString() {
        return "SWbean{" +
                "command=" + command +
                ", recommand=" + recommand +
                ", result=" + result +
                '}';
    }
}
