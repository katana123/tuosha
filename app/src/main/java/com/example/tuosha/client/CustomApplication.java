package com.example.tuosha.client;

import android.app.Application;
import android.content.Context;

import com.example.tuosha.ApplyActivity;
import com.example.tuosha.CardActivity;
import com.example.tuosha.CardContentActivity;
import com.example.tuosha.CardSecondActivity;
import com.example.tuosha.ContentActivity;
import com.example.tuosha.ContentWebActivity;
import com.example.tuosha.LoginActivity;
import com.example.tuosha.MainActivity;
import com.example.tuosha.RegisterActivity;
import com.example.tuosha.WelcomeActivity;
import com.example.tuosha.BankSecondActivity;
import com.example.tuosha.model.AlipayEntity;
import com.example.tuosha.model.BankCardsEntity;
import com.example.tuosha.model.CategoriesEntity;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.DaikuansEntity;
import com.example.tuosha.model.EDusEntity;
import com.example.tuosha.model.HkjBannersEntity;
import com.example.tuosha.model.HkjsEntity;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;
import com.example.tuosha.model.JieQianBannersEntity;
import com.example.tuosha.model.JieQianJqCatEntity;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.model.KouziBean;
import com.example.tuosha.model.MigrationsEntity;
import com.example.tuosha.model.MobileversionEntity;
import com.example.tuosha.model.MoneyRecordsEntity;
import com.example.tuosha.model.NoticesEntity;
import com.example.tuosha.model.OrdersEntity;
import com.example.tuosha.model.PasswordResetsEntity;
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.model.ProcessesEntity;
import com.example.tuosha.model.ProductsEntity;
import com.example.tuosha.model.SettingsEntity;
import com.example.tuosha.model.TiEsEntity;
import com.example.tuosha.model.ToolsEntity;
import com.example.tuosha.model.UsersEntity;
import com.example.tuosha.model.XinYongKasEntity;
import com.example.tuosha.model.XykBannersEntity;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class CustomApplication extends Application implements UncaughtExceptionHandler {
	private ArrayList<ContentBean> ContentList;
	private ArrayList<ContentBean> ContentSecondList;
	private ArrayList<KouziBean> list;
	private ArrayList<KouziBean> secondlist;
	private String userName;
	private ContentActivity ContentActivity;

	public com.example.tuosha.ContentActivity getContentActivity() {
		return ContentActivity;
	}

	public void setContentActivity(com.example.tuosha.ContentActivity contentActivity) {
		ContentActivity = contentActivity;
	}

	public ArrayList<ContentBean> getContentList() {
		return ContentList;
	}

	public void setContentList(ArrayList<ContentBean> contentList) {
		ContentList = contentList;
	}

	public ArrayList<ContentBean> getContentSecondList() {
		return ContentSecondList;
	}

	public void setContentSecondList(ArrayList<ContentBean> contentSecondList) {
		ContentSecondList = contentSecondList;
	}

	public ArrayList<KouziBean> getList() {
		return list;
	}

	public void setList(ArrayList<KouziBean> list) {
		this.list = list;
	}

	public ArrayList<KouziBean> getSecondlist() {
		return secondlist;
	}

	public void setSecondlist(ArrayList<KouziBean> secondlist) {
		this.secondlist = secondlist;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMailpassword() {
		return mailpassword;
	}

	public void setMailpassword(String mailpassword) {
		this.mailpassword = mailpassword;
	}

	public static void setInstance(CustomApplication instance) {
		CustomApplication.instance = instance;
	}

	private String passWord;
	private LoginActivity LoginActivity;
	private WelcomeActivity WelcomeActivity;
	private RegisterActivity registerActivity;
	private MainActivity mainActivity;
	private BankSecondActivity BankSecondActivity;
	private CardSecondActivity cardSecondActivity;
	private CardActivity CardActivity;
	private CardContentActivity cardContentActivity;
    private ApplyActivity applyActivity;
	private ContentWebActivity contentWebActivity;

	private ArrayList<ImsXuanMixloanBankEntity> bankEntityArrayList;
	private ArrayList<ImsXuanMixloanBankCardEntity> cardEntityArrayList;
	private ArrayList<ImsXuanMixloanProductEntity> productEntityArrayList;
// 新加表
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

	private String mailusername;
	private String mailpassword;
	private String phone;
	private String vcode;
	private static CustomApplication instance;


	public ArrayList<ImsXuanMixloanProductEntity> getProductEntityArrayList() {
		return productEntityArrayList;
	}

	public void setProductEntityArrayList(ArrayList<ImsXuanMixloanProductEntity> productEntityArrayList) {
		this.productEntityArrayList = productEntityArrayList;
	}


	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
        Thread.setDefaultUncaughtExceptionHandler(this);

	}
	 @Override  
	    public void onCreate() {  
	        super.onCreate();  
//	        CrashHandler crashHandler = CrashHandler.getInstance();  
//	        crashHandler.init(getApplicationContext());  
//	        globalDataHashMap = new HashMap<String, String>();
		 //setMailusername("sdfsdff");
		 instance = this;
	    }

	// 获取Application
	public static Context getMyApplication() {
		return instance;
	}

	public static CustomApplication getInstance() {
		return instance;
	}





	//共享全局变量
	//实体类列表
	public ArrayList<ImsXuanMixloanBankEntity> getBankEntityArrayList() {
		return bankEntityArrayList;
	}

	public void setBankEntityArrayList(ArrayList<ImsXuanMixloanBankEntity> bankEntityArrayList) {
		this.bankEntityArrayList = bankEntityArrayList;
	}

	public ArrayList<ImsXuanMixloanBankCardEntity> getCardEntityArrayList() {
		return cardEntityArrayList;
	}

	public void setCardEntityArrayList(ArrayList<ImsXuanMixloanBankCardEntity> cardEntityArrayList) {
		this.cardEntityArrayList = cardEntityArrayList;
	}

	public String getMailusername() {
		return mailusername;
	}
	public void setMailusername(String mailusername) {
		this.mailusername = mailusername;
	}
	public LoginActivity getLoginActivity() {
		return LoginActivity;
	}
	public void setLoginActivity(LoginActivity loginActivity) {
		LoginActivity = loginActivity;
	}
	public WelcomeActivity getWelcomeActivity() {
		return WelcomeActivity;
	}
	public void setWelcomeActivity(WelcomeActivity welcomeActivity) {
		WelcomeActivity = welcomeActivity;
	}

	public BankSecondActivity getBankSecondActivity() {
		return BankSecondActivity;
	}

	public void setBankSecondActivity(com.example.tuosha.BankSecondActivity bankActivity) {
		BankSecondActivity = bankActivity;
	}

	public com.example.tuosha.CardActivity getCardActivity() {
		return CardActivity;
	}

	public void setCardActivity(com.example.tuosha.CardActivity cardActivity) {
		CardActivity = cardActivity;
	}

	public RegisterActivity getRegisterActivity() {
		return registerActivity;
	}

	public void setRegisterActivity(RegisterActivity registerActivity) {
		this.registerActivity = registerActivity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}



	//新加表

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

	public MainActivity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	public CardSecondActivity getCardSecondActivity() {
		return cardSecondActivity;
	}

	public void setCardSecondActivity(CardSecondActivity cardSecondActivity) {
		this.cardSecondActivity = cardSecondActivity;
	}

	public CardContentActivity getCardContentActivity() {
		return cardContentActivity;
	}

	public void setCardContentActivity(CardContentActivity cardContentActivity) {
		this.cardContentActivity = cardContentActivity;
	}

    public ApplyActivity getApplyActivity() {
        return applyActivity;
    }

    public void setApplyActivity(ApplyActivity applyActivity) {
        this.applyActivity = applyActivity;
    }

	public ContentWebActivity getContentWebActivity() {
		return contentWebActivity;
	}

	public void setContentWebActivity(ContentWebActivity contentWebActivity) {
		this.contentWebActivity = contentWebActivity;
	}
}


