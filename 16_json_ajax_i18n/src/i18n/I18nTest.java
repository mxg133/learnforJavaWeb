package i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 孟享广
 * @date 2020-11-02 4:55 下午
 * @description
 * 4、i18n 国际化(了解内容)
 *
 * 4.1、什么是 i18n 国际化?
 *       国际化(Internationalization)指的是同一个网站可以支持多种不同的语言，以方便不同国家，不同语种的用户访问。
 *       关于国际化我们想到的最简单的方案就是为不同的国家创建不同的网站，比如苹果公司，他的英文官网是:
 *           http://www.apple.com 而中国官网是 http://www.apple.com/cn
 *       苹果公司这种方案并不适合全部公司，而我们希望相同的一个网站，而不同人访问的时候可以根据用户所在的区域显示
 *           不同的语言文字，而网站的布局样式等不发生改变。
 *       于是就有了我们说的国际化，国际化总的来说就是同一个网站不同国家的人来访问可以显示出不同的语言。但实际上这
 *           种需求并不强烈，一般真的有国际化需求的公司，主流采用的依然是苹果公司的那种方案，为不同的国家创建不同的页
 *           面。所以国际化的内容我们了解一下即可。
 *       国际化的英文 Internationalization，但是由于拼写过长，老外想了一个简单的写法叫做 I18N，代表的是 Internationalization
 *           这个单词，以 I 开头，以 N 结尾，而中间是 18 个字母，所以简写为 I18N。以后我们说 I18N 和国际化是一个意思。
 *
 * 4.2、国际化相关要素介绍
 *
 * 4.3、国际化资源 properties 测试
 *      配置两个语言的配置文件:
 *      i18n_en_US.properties 英文
 *
 */
public class I18nTest {
    @Test
    public void testLocale(){
        // 获取你系统默认的语言。国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);

//        Locale[] availableLocales = Locale.getAvailableLocales();
//        for (Locale locale1: availableLocales) {
//            System.out.println(locale1);


        // 获取中文，中文的常量的Locale对象
        System.out.println(Locale.CHINA);
        // 获取英文，美国的常量的Locale对象
        System.out.println(Locale.US);
    }
    
    @Test
    public void testI18n(){
        Locale locale = Locale.CHINA;
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        System.out.println(username);
        System.out.println(password);
    }
}