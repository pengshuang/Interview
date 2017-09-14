## 羽毛球馆 文档

## 说明

### 使用方法
调用 ThoughtWorks 类执行, 从控制台读取输入信息, 当需要查看当前收入时,输入 **check** 即可。

运行主函数

```java
public static void main(String[] args) {
    ThoughtWorks t = new ThoughtWorks();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
        t.summary(sc.nextLine());
    }
}
```

### 输入示例 1

#### 读取预订信息

	Input: U001 2016-06-02 22:00~22:00 A
	Output: Error: the booking is invalid!
	
	Input: U002 2017-08-01 19:00~22:00 A
	Output: Success: the booking is accepted!
	
	Input: U003 2017-08-02 13:00~17:00 B
	Output: Success: the booking is accepted!
	
	Input: U004 2017-08-03 15:00~16:00 C
	Output: Success: the booking is accepted!
	
	Input: U005 2017-08-05 09:00~11:00 D
	Output: Success: the booking is accepted!

#### 查看当前收入

	Input: check
	Output: 
	收入汇总
	---
	场地:A
	2017-08-01 19:00~22:00 200元
	小计: 200元
	
	场地:B
	2017-08-02 13:00~17:00 200元
	小计: 200元
	
	场地:C
	2017-08-03 15:00~16:00 50元
	小计: 50元
	
	场地:D
	2017-08-05 09:00~11:00 80元
	小计: 80元
	---
	总计: 530元

### 输入示例 2

#### 读取预订信息

	Input: U002 2017-08-01 19:00~22:00 A
	Output: Success: the booking is accepted!
	
	Input: U003 2017-08-01 18:00~20:00 A
	Output: Error: the booking conflicts with existing bookings!
	
	Input: U002 2017-08-01 19:00~22:00 A C
	Outpu: Success: the booking is accepted!
	
	Input: U002 2017-08-01 19:00~22:00 A C
	Outpu: Error: the booking being cancelled does not exist!
	
	Input: U003 2017-08-01 18:00~20:00 A
	Outpu: Success: the booking is accepted!
	
	Input: U003 2017-08-02 13:00~17:00 B
	Outpu: Success: the booking is accepted!

#### 查看当前收入

	Input: check
	Output: 
	收入汇总
	---
	场地:A
	2017-08-01 18:00~20:00 160元
	2017-08-01 19:00~22:00 违约金 100元
	小计: 260元
	
	场地:B
	2017-08-02 13:00~17:00 200元
	小计: 200元
	
	场地:C
	小计: 0元
	
	场地:D
	小计: 0元
	---
	总计: 460元