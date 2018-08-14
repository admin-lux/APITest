package com.rick.test;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.lang.Console;

/**
 * 验证码
 * 
 * @author rick_lu
 *
 */
public class CaptchaTest {

	public static void main(String[] args) {
		 getLineCaptcha();
		// getCircleCaptcha();
		// getShearCaptcha();
	}

	/**
	 * 线段干扰的验证码
	 */
	public static void getLineCaptcha() {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

		// 生成验证码
		lineCaptcha.createCode();
		// 图形验证码写出，可以写出到文件，也可以写出到流
		// lineCaptcha.write(new File("e:/line.png"));
		// 输出code
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");

		// 重新生成验证码
		lineCaptcha.createCode();
		// lineCaptcha.write("d:/line.png");
		// 新的验证码
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");
	}

	/**
	 * 圆圈干扰验证码
	 */
	public static void getCircleCaptcha() {
		// 定义图形验证码的长、宽、验证码字符数、干扰元素个数
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
		// CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);

		captcha.createCode();
		// 图形验证码写出，可以写出到文件，也可以写出到流
		// captcha.write("d:/circle.png");
		// 输出code
		Console.log(captcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		captcha.verify("1234");
	}

	/**
	 * 扭曲干扰验证码
	 */
	public static void getShearCaptcha() {
		// 定义图形验证码的长、宽、验证码字符数、干扰线宽度
		ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
		// ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);

		captcha.createCode();
		// 输出code
		Console.log(captcha.getCode());
		// 图形验证码写出，可以写出到文件，也可以写出到流
		// captcha.write("d:/shear.png");
		// 验证图形验证码的有效性，返回boolean值
		System.out.println(captcha.verify("1234"));
	}

}
