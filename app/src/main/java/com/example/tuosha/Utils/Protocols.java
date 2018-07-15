package com.example.tuosha.Utils;

/**
 * Created by kasim on 15-2-10.
 */
public class Protocols {
    //与服务器通信的协议
    public static final byte DEFAULT = 0x00;
    //心跳
    public static final byte HEART_BEAT = 0x01;
    //用户的访问权限,有可以访问,无法访问需要注册,已注册等待授权三种
    public static final byte PERMISSION = 0x02; //返回协议值:0表示用户未注册,1表示用户已注册但未授权,2表示用户可以登录
    public static final byte BANK = 0x3f; //银行列表
    //登陆协议,登陆成功和登录失败
    public static final byte LOGIN = 0x03; // 返回协议值:0代表登录用户名不存在,1代表登陆成功,2代表登录密码错误,3代表用户信息与绑定设备不匹配
    //客户端崩溃,发送记录日志给服务端
    public static final byte CRASH = 0x04;
    //下面的协议用于注册
    public static final byte CHECK_USRNAME = 0x05; //检测用户名是否可用,返回协议值:1代表用户名可用,其他值代表用户名已被占用
    public static final byte GET_DEPARTMENT_INFOS = 0x06; //获取部门层级信息
    public static final byte REGISTER = 0x07; //提交注册信息

    //内网报表
    public static final byte REPORT_INNERREPORT = 0x08;
    //动态新闻
    public static final byte DYNAMIC_NEWS = 0x09;

    /**
     * 行业动态信息,模块有16项,分别为: (除了15之外,其他的模块都是先获取项目的列表,然后根据项目的名称获取具体的数据,因此获取数据的方式如下(例子):
     *  镀锌彩涂板 -> (镀锌板卷 1.0mmSGCC,彩涂板卷 0.476mm) -> 获取具体的数据
     *                                                   -> 获取图形数据)
     *
     * 0:进口铁矿石 ->有表格数据(可以选择日期),无图形数据
     * 1:长材 ->有表格数据(可以选择日期),有图形数据
     * 2:板材 ->同上
     * 3:镀锌彩涂板 ->同上
     * 4:优特钢 ->同上
     * 5:不锈钢 ->同上
     * 6:钢铁原料 ->有表格数据(可以选择日期),有图形数据(数据分为两种:日报,周报)
     * 7:铁合金现货 ->同上
     * 8:钢材基准 ->有表格数据(不可以选择日期),有图形数据(数据分为两种:日报,周报)
     * 9:铁矿石 ->同上
     * 10:铁合金 ->同上
     * 11:钢坯 ->同上
     * 12:煤炭基准 ->同上
     * 13:有色金属 ->同上
     * 14:废钢 ->同上
     * 15:普氏62%铁矿石 ->直接获取具体数据,而不是先获取列表,与上面的模块独立
     */
    public static final byte CVAS_TYPE = 0x0a; //获取项目的列表
    public static final byte CVAS_DATA = 0x0b; //获取具体的表格数据
    /**
     * 上面所述可知,这里有三种情况
     * 1:图形数据(没有日报,周报之分)
     * 2:图形数据(日报)
     * 3:图形数据(周报)
     */
    public static final byte CVAS_DATA_PICTURE = 0x0e; //获取项目的图形数据

    public static final byte CLOUD_FILES = 0x0f; //云文件

    public static final byte BG_FILE = 0x50;//宝钢文件

    /**
     * 领导参考资讯模块:每日早参,证券快报,要情快报,产销研快速响应市场协调会
     */
    public static final byte DAILY_BREAKFAST_MRZC = 0x10;
    public static final byte DAILY_BREAKFAST_ZQKB = 0x11;
    public static final byte DAILY_BREAKFAST_YQKB = 0x12;
    public static final byte DAILY_BREAKFAST_CXYTHYJL = 0x13;
    //获取上面4个协议的具体数据
    public static final byte DAILY_BREAKFAST_DATA = 0x14;
    //外网报表
    public static final byte BUSINESS_INTEL_EIGHT_PRICE = 0x15;
    public static final byte BUSINESS_INTEL_STEEL_PRICE = 0x16;
    public static final byte BUSINESS_INTEL_EIGHT_PRICE_CHAT = 0x17;
    public static final byte BUSINESS_INTEL_STEEL_PRICE_CHAT = 0x18;
    //情报信息
    public static final byte BUSINESS_INTEL_GM = 0x19;
    public static final byte BUSINESS_INTEL_FINANCE = 0x1a;
    //制造部公文
    public static final byte DOCUMENT_ZZB_SEND = 0x1b;
    public static final byte DOCUMENT_ZZB_SP = 0x1c;
    public static final byte DOCUMENT_ZZB_YB_LIST = 0x1d;
    public static final byte DOCUMENT_ZZB_YB_DATA = 0x1e;
    public static final byte DOCUMENT_ZZB_DB_LIST = 0x1f;
    public static final byte DOCUMENT_ZZB_DB_DATA = 0x20;
    public static final byte CLOUD_FILES_CREATE_FOLDER = 0x21;
    public static final byte DOCUMENT_ZZB_SAVE = 0x22;
    //股份公文
    public static final byte DOCUMENT_GF_UNF = 0x23;
    public static final byte DOCUMENT_GF_QS = 0x24;
    public static final byte DOCUMENT_GF_QS_UPDATE = 0x25;
    public static final byte DOCUMENT_SPCIFIC = 0x26;
    public static final byte DOCUMENT_GF_SECRETARY_SEND_YB = 0x27;
    public static final byte DOCUMENT_GF_YB = 0x2e;
    /**
     * 公文模块手写签批
     */
    public static final byte DOCUMENT_SIGN_IMG = 0x28;
    //秘书公文模块
    public static final byte DOCUMENT_GF_SECRETARY_WB = 0x29; //未办公文(有可能是PC端发起的空白公文,也有可能是其他领导处理过后经由其秘书转发而来)
    public static final byte DOCUMENT_GF_SECRETARY_LDYSP = 0x2a; //领导已经审批过的公文
    public static final byte DOCUMENT_GF_GW_DATA = 0x2b; //获取公文详细数据
    public static final byte DOCUMENT_GF_SECRETARY_SEND_DB = 0x2c;//秘书发送公文给领导
    public static final byte DOCUMENT_GF_LD_SEND_DB= 0x2d;//领导发送公文
    public static final byte USER_ADVICE = 0x2f;//客户端意见反馈模块

    //新添报表
    public static final byte NEW_HBXT = 0x30; //汇报系统
    public static final byte HBXT_YHFYYJ = 0x21; //汇报系统用户反映意见
    public static final byte HBXT_HTWCQK = 0x22; //汇报系统合同完成情况*/
}
