package com.example.tuosha.client;

import android.app.Application;
import android.content.Context;

import com.example.tuosha.CardActivity;
import com.example.tuosha.ContentActivity;
import com.example.tuosha.LoginActivity;
import com.example.tuosha.RegisterActivity;
import com.example.tuosha.WelcomeActivity;
import com.example.tuosha.BankSecondActivity;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;
import com.example.tuosha.model.KouziBean;

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
	private BankSecondActivity BankSecondActivity;
	private CardActivity CardActivity;
	private ArrayList<ImsXuanMixloanBankEntity> bankEntityArrayList;
	private ArrayList<ImsXuanMixloanBankCardEntity> cardEntityArrayList;
	private ArrayList<ImsXuanMixloanProductEntity> productEntityArrayList;
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
}


