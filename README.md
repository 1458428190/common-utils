# common-utils
### MapUtils (Map相关工具)
1. getKeyForMostValue(Map<K, V> map, MostType type): 取最值value对应的key (如最大最小)
```java
// 取最小
MapUtils<Object, Long> mapUtils = new MapUtils<Object, Long>();
mapUtils.put("aaa", 1L);
mapUtils.put("bbb", 2L);
Object key = mapUtils.getKeyForMostValue(MapUtils.MostType.MIN);   // 取最大是MAX
```
### StringFormatUtils (数值格式转换相关工具)
1. formatRound(double num, int digit):将Double数值, 四舍五入, 格式化数值为digit位, 转成String
```java
double number = 2.1234567;
int digit = 2;
String result = StringFormatUtils.formatRound(number, digit);
```
2. formatNoRound(double num, int digit):将Double数值, 不四舍五入, 格式化数值为digit位, 转成String
```java
double number = 2.1234567;
int digit = 2;
String result = StringFormatUtils.formatNoRound(number, digit);
```
### XMLUtils (XML解析相关工具)
1. getBean(String filePath, String beanId): 通过读取配置文件中的类名创建Bean
```xml
<?xml version = "1.0"?>
<config>
    <bean id="xxxBean">com.gdufe.test.domain.XxxBean</bean>
</config>
```
```java
String filePath = "c:/xxx/xxx/config.xml";
String beanId = "xxxBean";
Object bean = XMLUtils.getBean(filePath, beanId);
```
