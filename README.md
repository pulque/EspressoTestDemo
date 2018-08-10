# EspressoTestDemo
**本项目研究Espresso测试**

## 主要内容
> #### 1. 参考资料
> #### 2. 代码设计
> #### 3. 基本配置
> #### 4. 项目介绍
> #### 5. 需要注意
> #### 6. 存在的疑问

## 正文
### 1. 参考资料
Espresso官方开发文档： 
https://developer.android.com/training/testing/espresso/?hl=zh-cn   
Espresso官方开发文档： 
https://github.com/googlesamples/android-testing  
### 2. 代码设计
先用录制工具初始化大部分代码，然后根据实际需求修改。  

![录制工具入口](https://github.com/pulque/EspressoTestDemo/blob/master/images/20180810165352.png?raw=true)  
  
尽量涵盖应用的所有正常流程。  
    
例如：登录  
2.1 注册等待监听（IdlingResource）  
2.2 初始化数据库等需要用到的基本对象和数据  
2.3 启动页面  
2.4 输入用户名密码  
2.5 登录并等待主页打开  
2.6 检测Intent，并判断主页信息  
### 3. 基本配置
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test:rules:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:'+rootProject.espressoVersion
    androidTestImplementation 'com.android.support.test.espresso:espresso-intents:'+rootProject.espressoVersion
    // Note that espresso-idling-resource is used in the code under test.
    implementation 'com.android.support.test.espresso:espresso-idling-resource:' + rootProject.espressoVersion
    // App's dependencies, including test
    implementation 'com.android.support:support-annotations:27.1.1'  
### 4. 项目介绍
本项目并不能直接运行测试，只是把测试的框架和方式展现出来。  
实际的测试代码是可以运行通过的，期间也很依赖于应用的源码，  
甚至还需要在源码中添加一些阻断测试的设置。  
###### 4.1 BooleanIdlingResource
用于在应用执行耗时操作时，阻断测试的工具。  
需要在 **@Before** 注册，在 **@After** 取消。  
设置阻断超时时间代码：  

    IdlingPolicies.setMasterPolicyTimeout(60 * 1000 * 3, TimeUnit.MILLISECONDS);
    IdlingPolicies.setIdlingResourceTimeout(60 * 1000 * 3, TimeUnit.MILLISECONDS);
###### 4.2 BaseActivityTest
所有测试脚本的父类，主要设置阻断监听和初始化启动页面。  
###### 4.3 FindViewUtils
基于录制工具生成代码的抽象。

### 5. 需要注意
> + IdlingResource的注册一定要在启动页面之前。 
> + 一直停在longClick()命令，可能是没有找到View。  
### 6. 存在的疑问
不知道在以后的开发中用处大不……  
  
  
最后，有一点好处是可以使用Google的Firebase进行测试！！  
https://console.firebase.google.com/
    
