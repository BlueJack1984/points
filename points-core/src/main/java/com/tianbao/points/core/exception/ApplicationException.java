package com.tianbao.points.core.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应用异常
 * @author lushusheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SUCCEED = 0;

	public static int INNER_ERROR = 1;
	public static int PARAM_ERROR = 2;
	public static int NO_LOGIN = 3;
	public static int NO_PHONE = 4;
	public static int PHONE_USED = 5;
	public static int CODE_AGAIN = 6;
	public static int RESET_PASSWORD = 7;
	public static int NO_REGISTER = 8;
	public static int CODE_TIMEOUT = 9;
	public static int NO_CODE = 10;
    public static int CODE_ERROR = 11;
	public static int USER_UNCOMPLETE = 12;
	public static int USER_ERROR =13;
	public static int PHONE_SAME =14;
	public static int LOGINNAME_USED =15;
	public static int LOGINNAME_UNCORR = 16;
	public static final int NO_BINDING = 17;
	public static int PASSWORD_ERROR = 18;
	public static int RESOURCE_ERROR = 19;
	public static final int MYSQL_ERROR = 20;
	public static final int PASSWORD_FORMAT_ERROR = 21 ;
	//错误的操作
	public static final int WRONG_OPERATION = 22 ;
	public static int LOGIN_FORBID = 23;
	public static final int ALIBABAREVIEW = 24;
	public static final int SENSITIVE_WORDS= 25;
	public static final int ALIBABAREVIEWHTTP = 26;
	public static final int ALIBABAREVIEWINTERFACE = 27;
	public static final int ALIBABA_REVIEW_PROFILE = 28;
	public static final int ALIBABA_REVIEW_ACTION = 29;
	public static final int ALIBABA_REVIEW_RESULT = 30;
	public static final int ALIBABA_OSS = 31;
	public static final int USER_NOT_EXISTS = 32;
	public static final int USER_NOT_EMPLOYEE = 33;
	public static final int DB_RECORD_DUPLICATED = 34;
	public static final int DEPT_HAVE_ENPLOYEE = 35;
	public static final int ROLE_NOT_EXISTS = 36;
	public static final int ROLE_NOT_INNER = 37;
	public static final int SENSITIVE_NO_RW_AUTHORIZATION = 38;
	public static final int ROLE_HAVE_ENPLOYEE = 39;
	public static final int ROLE_HAVE_NAME = 40;
    /**
     * 短信申请太频繁
     */
    public static final int SMS_APPLY_FREQUENCY = 41;
    /**
     * 短信申请超过了当天限制了
     */
    public static final int SMS_APPLY_LIMIT = 42;
	/**
	 * 短信验证码未申请
	 */
	public static final int SMS_NOT_APPLIED = 43;
	/**
	 * 短信验证码无法继续验证
	 */
	public static final int SMS_CANNOT_VERIFY = 44;
	/**
	 * 解密解密失败
	 */
	public static final int CRYPTO_ERROR = 45;
	/**
	 * 短信验证码不匹配
	 */
	public static final int SMS_CODE_MIS_MATCH = 46;
	/**
	 * 用户已经绑定了其它微信账号
	 */
	public static final int USER_BIND_OTHER_WE_CHAT = 47;
	/**
	 * 用户不属于相同的域
	 */
	public static final int USER_DOMAIN_MISMATCH = 48;
	/**
	 * 微信已经绑定到其它用户
	 */
	public static final int WE_CHAT_ALREADY_BIND_OTHER = 49;
	/**
	 * 不支持的短信验证码类型
	 */
	public static final int SMS_CODE_UNSUPPORTED = 50;
	/**
	 * 登录用户不能停用自己
	 */
	public static final int USER_FORBID_OWN = 51;

	public static final int STATUS_CHANGE_UNSUPPORTED = 52;

    /**
     * jwt错误
     */
    public static final int JWT_BASE = 100;
    /**
     * 缺少jwt认证信息
     */
	public static final int JWT_LACK = 101;
    /**
     * jwt认证失效
     */
    public static final int JWT_EXPIRE = 102;
    /**
     * 不支持的认证信息
     */
    public static final int JWT_TOKEN = 103;
    /**
     * jwt时间戳无效
     */
    public static final int JWT_STAMP_FORMAT = 104;
    /**
     * jwt签名错误
     */
    public static final int JWT_SIGN = 105;
    /**
     * jwt参数非法
     */
    public static final int JWT_ILLEGAL = 106;
    /**
     * jwt中用户id非法
     */
    public static final int JWT_USER_ID = 107;
    /**
     * jwt的用户不存在
     */
    public static final int JWT_USER = 108;
    /**
     * 缺少签名信息
     */
    public static final int JWT_SIGN_LACK = 109;
    /**
     * 签名格式错误
     */
    public static final int JWT_SIGN_FORMAT = 110;
    /**
     * 核对签名异常
     */
    public static final int JWT_SIGN_EXP = 111;
    /**
     * 签名不一致
     */
    public static final int JWT_SIGN_VERIFY = 112;
    /**
     * 签名的时间戳和当前时间相差太大
     */
    public static final int JWT_STAMP_DIFF = 113;
    /**
     * 令牌格式错误
     */
    public static final int JWT_FORMAT = 114;

    /**
     * 权限相关的错误
     */
	public static final int SC_BASE = 200;
    /**
     * 功能权限不存在
     */
	public static final int SC_AUTHORITY_NOT_EXIST = 201;
    /**
     * 用户没有分配该权限
     */
	public static final int SC_NO_AUTHORITY = 202;
	/**
	 * 功能权限没有配置字段权限
	 */
	public static final int SC_AUTHORITY_NO_ATTRIBUTE = 203;
	/**
	 * 字段权限超出了限制范围
	 */
	public static final int SC_AUTHORITY_ATTRIBUTE_OUT_RANGE = 204;
    /**
     * 用户未登录
     */
	public static final int SC_NO_LOGIN = 205;
    /**
     * 无效的登录状态
     */
	public static final int SC_INVALID_LOGIN = 206;
	/**
	 * 功能权限域不正确
	 */
	public static final int SC_DOMAIN = 207;
    /**
     * 权限id不是产品
     */
	public static final int SC_AUTHORITY_NOT_PRODUCT = 208;
    /**
     * 没有对产品进行授权
     */
	public static final int SC_AUTHORITY_PRODUCT = 209;
	/**
	 * 不支持的登录模式
	 */
	public static final int SC_LOGIN_UNSUPPORTED = 210;
	/**
	 * 微信申请令牌异常
	 */
	public static final int SC_WECHAT_TOKEN_REQUEST = 211;
	/**
	 * 微信未登录
	 */
	public static final int SC_WE_CHAT_NO_LOGIN = 212;
	/**
	 * 登录模式不是微信登录
	 */
	public static final int SC_LOGIN_MODE_NOT_WE_CHAT = 213;
	/**
	 * 功能权限不支持匿名访问
	 */
	public static final int SC_AUTHORITY_NOT_ALLOW_ANONYMOUS = 214;
	/**
	 * 功能权限没有配置支持的接口列表
	 */
	public static final int SC_AUTHORITY_NOT_CONFIGURE_API = 215;
	/**
	 * 功能权限不支持的接口
	 */
	public static final int SC_AUTHORITY_NOT_SUPPORTED_API = 216;
	/**
	 * 没有找到请求的服务
	 */
	public static final int SERVICE_NOT_FOUND = 998;
	/**
	 * 未知错误
	 */
    public static final int UNKNOWN = 999;

	private static final String[] ERROR_DESC_LIST = new String[] { "",
			"内部错误.", "参数错误", "用户没有登录","请输入手机号","此手机号已经被占用","验证码已发送,请稍后再试...",
			"手机号,验证码,新密码均不能为空","该手机号没注册","验证码超时,请重新获取","请先获取验证码","验证码错误",
			"用户名,密码不能为空","用户名,密码错误","新老手机号不能相同","邮箱账号名已被占用","用户名不合法(字母数字下划线)",
			"未绑定账号","密码错误","资源上传错误","数据库异常操作失败","密码是由数字英文组成的6-20位字符串","错误的操作",
			"该账号已被停用","阿里审核图片错误","敏感信息","阿里接口请求http错误","阿里接口错误",
			"阿里敏感审核接口配置错误","阿里敏感审核接口执行异常","阿里敏感审核接口返回内容异常",
			"OSS文件上传异常", "不存在该用户", "用户不是内部员工","数据库记录重复","无法删除该部门，该部门下有员工","不存在该角色",
			"角色不是内部角色","功能权限没有读取和写入进行字段鉴权","无法删除该角色，该角色下还有账号或者停用账号","角色名已被占用",
            "短信申请太频繁","短信申请超过当天限制","未申请短信验证码","短信验证码无法继续验证","加密解密失败",
			"短信验证码不一致","用户已经绑定了其它微信","用户不属于相同的域","微信已经被其它用户绑定",
			"不支持的短信验证码类型","登录用户不能停用或者启用自己", "该数据的状态不支持此操作"
	};

	private static final String[] ERROR_JWT_LIST = new String[]{"",
			// JWT_LACK
    		"头部缺少认证信息",
			// JWT_EXPIRE
			"头部认证信息已经失效",
			// JWT_TOKEN
			"不支持的头部认证信息",
			// JWT_STAMP_FORMAT
			"头部认证信息时间戳无效",
			// JWT_SIGN
    		"头部认证信息签名错误",
			// JWT_ILLEGAL
			"头部认证信息参数非法",
			// JWT_USER_ID
			"头部认证的用户id非法",
			// JWT_USER
			"头部认证的用户不存在",
			// JWT_SIGN_LACK
    		"头部缺少签名信息",
			// JWT_SIGN_FORMAT
			"头部签名信息格式错误",
			// JWT_SIGN_EXP
			"头部签名信息核对异常",
			// JWT_SIGN_VERIFY
			"头部签名信息不一致",
			// JWT_STAMP_DIFF
    		"终端的时间戳和服务器的时间戳相差太大",
            // JWT_FORMAT
            "令牌格式错误"
	};

	private static final String[] ERROR_SC_LIST = new String[]{"",
			// SC_AUTHORITY_NOT_EXIST
			"不存在该权限对象",
			// SC_NO_AUTHORITY
			"用户没有分配该权限",
			// SC_AUTHORITY_NO_ATTRIBUTE
			"功能权限不限制字段权限",
			// SC_AUTHORITY_ATTRIBUTE_OUT_RANGE
			"字段权限超出了限制范围",
			// SC_NO_LOGIN
			"用户未登录",
			// SC_INVALID_LOGIN
    		"登录状态无效",
			// SC_DOMAIN
			"功能权限域不匹配",
            // SC_AUTHORITY_NOT_PRODUCT
            "功能权限不是有效产品",
            // SC_AUTHORITY_PRODUCT
            "没有授权该产品给用户",
			// SC_LOGIN_UNSUPPORTED
			"不支持的登录模式",
			// SC_WECHAT_TOKEN_REQUEST
			"申请微信令牌异常",
			// SC_WE_CHAT_NO_LOGIN
			"微信未登录",
			// SC_LOGIN_MODE_NOT_WE_CHAT
			"登录模式不是微信登录",
			// SC_AUTHORITY_NOT_ALLOW_ANONYMOUS
			"功能权限不支持匿名访问",
			// SC_AUTHORITY_NOT_CONFIGURE_API
			"功能权限没有配置接口",
			// SC_AUTHORITY_NOT_SUPPORTED_API
			"功能权限不支持的接口"
	};

	private int code;
	private String msg;
	private String detailMsg;

	public ApplicationException(int code) {
	    super();
		this.code = code;
		code2msg();
	}

	public ApplicationException(int code, String detailMsg) {
	    super();
		this.code = code;
		this.detailMsg = detailMsg;
		code2msg();
	}
	public ApplicationException(int code, String detailMsg, Integer a) {
	    super();
		this.code = code;
		//this.msg = ERROR_DESC_LIST[code];
		this.detailMsg = detailMsg;
	}
	private void code2msg(){
		if (code < JWT_BASE) {
			this.msg = ERROR_DESC_LIST[code];
		}else if (code < SC_BASE) {
			this.msg = ERROR_JWT_LIST[code - JWT_BASE];
		}else if (code == SERVICE_NOT_FOUND){
			this.msg = "没有找到请求的服务";
		}else if (code == UNKNOWN){
			this.msg = "未知错误";
		}else{
			this.msg = ERROR_SC_LIST[code - SC_BASE];
		}
	}
}
