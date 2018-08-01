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
### PagingUtils (分页相关工具)
1.getTotalPage( long count , int maxNum): 根据数据总数,每页显示个数 统计总页数
```java
    long count = 10;
    int maxNum = 5;
    int totalPage = getTotalpag e(count , maxNum);
```
2.getStart(int page , int maxNum)：根据当前页数,每页显示个数 计算表中数据的起始行
```java
    int page = 2;
    int maxNum = 5;
    int start  = getStart(page  , maxNum);
    List<xxx> lists = xxxDao.getXXX(start , maxNum);
```
### OkHttpUtils (OkHttp工具)
```java
1. public static void syncGet(String url) 同步Get操作
2. public static void asyncGet(String url) 异步Get请求
3. public static void timeOutPost(String url) 设置超时
```