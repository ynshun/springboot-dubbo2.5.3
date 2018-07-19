基于 spring-boot-starter-dubbo1.0.0(dubbo2.5.3) 搭建的一个简单基础框架
	
	本基础框架实现的需求点：
		
		1、Mybatis实现mysql读写分离；
		
		
	本框架的不足：
		由于Spring的事务是通过代理来实现，故在provider中如果启用事务（@Transactional）后，启用了Spring bean事务代理，导致Dubbo的AnnotationBean在扫码对应代码的时候获取不到对应的注解，导致无法注册；
		
		解决方案：
			
			1、使用@Transactional注解，通过xml配置文件来发布dubbo服务
			2、使用dubbo的@Service注解，通过xml配置来配置事务
			3、基于上面两种解决方案都需要通过xml方式来处理，无奈之下本人在provider中多提出来了一层（rpc），在rpc层中暴露dubbo服务，在rpc层内部来调用一次真实的业务逻辑代码
			
			不过根据网上查阅的资料来看，dubbo2.6已经解决了该问题，故放弃维护本架构，冲着dubbo2.6+去了，此处做一个记录，也为在学习dubbo的朋友当一个笔记来看看吧~~~~~
			
			
			
		附：在网上搜索出来的一些解决方案，本人未亲自试验，有需要的朋友可以玩一下下：
			https://blog.csdn.net/xiaozixiaohui/article/details/79130162
			http://jhaij.iteye.com/blog/2171723