package com.example.tuosha.client;

import android.R.integer;
import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;

import com.example.tuosha.CardActivity;
import com.example.tuosha.LoginActivity;
import com.example.tuosha.WelcomeActivity;
import com.example.tuosha.BankSecondActivity;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class CustomApplication extends Application implements UncaughtExceptionHandler {
	private LoginActivity LoginActivity;
	private WelcomeActivity WelcomeActivity;
	private BankSecondActivity BankSecondActivity;
	private CardActivity CardActivity;

	private ArrayList<ImsXuanMixloanBankEntity> bankEntityArrayList;



	private ArrayList<ImsXuanMixloanBankCardEntity> cardEntityArrayList;

	public ArrayList<ImsXuanMixloanProductEntity> getProductEntityArrayList() {
		return productEntityArrayList;
	}

	public void setProductEntityArrayList(ArrayList<ImsXuanMixloanProductEntity> productEntityArrayList) {
		this.productEntityArrayList = productEntityArrayList;
	}

	private ArrayList<ImsXuanMixloanProductEntity> productEntityArrayList;
	private String mailusername;
	private String mailpassword;
	private static CustomApplication instance;
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
	public static Context getInstance() {
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
}
