package date8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Jdk8date {

	public static void main(String[] args) {
		
		Jdk8date j=new Jdk8date();
//		j.testLocalDate();
//		j.testLocalTime();
//		j.testLocalDateTime();
//		j.testInstants();
//		j.testTransform();
//		j.testPeriod();
//		j.testDuration();
		j.testChronoUnit();
		
	}
	
	
	
	






	/**
	 * LocalDate是一个不可变的类，它表示默认格式(yyyy-MM-dd)的日期
	 */
	public void testLocalDate(){
		// 当前日期yyyy-MM-dd
		LocalDate localDate1= LocalDate.now();
		System.out.println(localDate1);
		 // 创建一个日期
		LocalDate localDate2=LocalDate.of(2019, 01, 01);
		System.out.println(localDate2);

		// 获取指定时区的当前时间
		
	/*	<timezone id="Asia/Shanghai">中国标准时间 (北京)</timezone>
		<timezone id="Asia/Hong_Kong">香港时间 (香港)</timezone>
		<timezone id="Asia/Taipei">台北时间 (台北)</timezone>
		<timezone id="Asia/Seoul">首尔</timezone>
		<timezone id="Asia/Tokyo">日本时间 (东京)</timezone>
		<timezone id="America/New_York">美国东部时间 (纽约)</timezone>*/

		LocalDate localDate3=LocalDate.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(localDate3);
		
		// 格林威治时间+天数
        //默认获取的是以UTC时区，世界协调时间，为基础
		LocalDate localDate4= LocalDate.ofEpochDay(365);
		System.out.println(localDate4);
		// 某年的第几天的日期
		LocalDate localDate5=LocalDate.ofYearDay(2018, 200);
		
		System.out.println(localDate5);
		
		
	}

	/**
	 * 
	 * LocalTime是一个不可变的类，它的实例代表一个符合人类可读格式的时间，默认格式是hh:mm:ss.zzz
	 */
	private void testLocalTime() {

		//当前时间
		LocalTime localTime1=  LocalTime.now();
		System.out.println("currentTime"+localTime1);
		//创建当前时间
		LocalTime  localTime2=   LocalTime.of(14, 20, 25, 00);
		System.out.println("Specific Time of Day="+localTime2);
		 // 获取指定时区当前时间
		LocalTime localTime3=  LocalTime.now(ZoneId.of("America/New_York"));
		LocalTime localTime4=  LocalTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println("America/New_York"+localTime3);
		System.out.println("china"+localTime4);
		 // 当天多少秒的时间
		LocalTime localTime5= LocalTime.ofSecondOfDay(10000);
		System.out.println(localTime5);
		
	}
	/**
	 * LocalDateTime是一个不可变的日期-时间对象，它表示一组日期-时间，默认格式是yyyy-MM-dd-HH-mm-ss.zzz。它提供了一个工厂方法，接收LocalDate和LocalTime输入参数，创建LocalDateTime实例。
	 */
	private void testLocalDateTime(){
		
		//当前日期时间
		LocalDateTime localDateTime1=  LocalDateTime.now();
		System.out.println("current dateTime"+localDateTime1);
		// 当前日期时间
		LocalDateTime localDateTime2=  LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("current dateTime"+localDateTime2);
		// 指定时间日期时间
		LocalDateTime localDateTime3=  LocalDateTime.of(2014, Month.JANUARY, 1, 10, 30);
		System.out.println("current dateTime"+localDateTime3);
		// 当前指定时区日期时间
		LocalDateTime localDateTime4=  LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("current dateTime"+localDateTime4);
		
		// 格林威治后多少分钟的日期时间
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970= "+dateFromBase);
	}
	/**
	 * Instant类是用在机器可读的时间格式上的，它以Unix时间戳的形式存储日期时间。
	 */
	private void testInstants(){
		 // 当前时间戳
		Instant timeStamp=   Instant.now();
		System.out.println("current timestamp"+timeStamp);
		
		Instant specificTime = Instant.ofEpochMilli(timeStamp.toEpochMilli());
		System.out.println(specificTime);
		Duration d=  Duration.ofDays(30);
		System.out.println(d);
		
		
		
	}
	
	
	private void testTransform(){
		
		//Date to Instant
		Instant timestamp= new Date().toInstant();
		System.out.println(timestamp+"   ---"+new Date());
		LocalDateTime date= LocalDateTime.ofInstant(timestamp, ZoneId.of("America/New_York"));
		
		System.out.println("instant now :"+timestamp+"  localDateTime newyork now :"+date);
		
		
		Instant instant=Instant.now();
		LocalDateTime local1=    LocalDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());
		System.out.println(local1);
		LocalDateTime local2= LocalDateTime.ofInstant(timestamp, ZoneId.of("America/New_York"));
		System.out.println(local2);
		LocalDateTime local3= LocalDateTime.ofInstant(timestamp, ZoneId.of("Asia/Shanghai"));
		System.out.println(local3);
		
		
		
		//Calendar to Instant
		Instant time= Calendar.getInstance().toInstant();
		System.out.println(time);
		
		 //TimeZone to ZoneId
		ZoneId defaultZone= TimeZone.getDefault().toZoneId();
		System.out.println(defaultZone);
		
		 //ZonedDateTime from specific Calendar
		
		ZonedDateTime  zonedDateTime=  new GregorianCalendar().toZonedDateTime();
		System.out.println(zonedDateTime);
		
		//Instant to Date
		Date dt=  Date.from(Instant.now());
		System.out.println(dt);
		
		
		// date to LocalDateTime
		
		Date d1=new Date();
        Instant instant1= d1.toInstant();
        LocalDateTime l1=  LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
        
        //date to LocalDate
        
        Date d2=new Date();
        Instant instant2= d2.toInstant();
        LocalDateTime localDateTime=  LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
		LocalDate localDate=localDateTime.toLocalDate();
		
		
		//LocalDateTime  date
		LocalDateTime llocalDateTime3=    LocalDateTime.now();
		Instant instant3=    llocalDateTime3.atZone(ZoneId.systemDefault()).toInstant();
		Date d3= Date.from(instant3);
		
//		LocalDate to Date
		LocalDate l4=  LocalDate.now();
		ZoneId zone= ZoneId.systemDefault();
		Instant instant4= l4.atStartOfDay().atZone(zone).toInstant();
		Date d4=Date.from(instant4);
		System.out.println(instant4+"--->"+d4);
		
		//LocalTime to Date
		LocalTime localt=  LocalTime.now();
		LocalDate locald= LocalDate.now();
		LocalDateTime localDatet=   LocalDateTime.of(locald, localt);
		Instant ins= localDatet.atZone(ZoneId.systemDefault()).toInstant();
		Date da=Date.from(ins);
		
	}
	
	//主要是Period类方法getYears（），getMonths（）和getDays（）来计算.
	private void testPeriod(){
		LocalDate today=  LocalDate.now();
		System.out.println("today:"+today);
		LocalDate birthDate=LocalDate.of(1992, 11, 13);
		System.out.println("birthDate:"+birthDate);
		Period p= Period.between(birthDate, today);
		
		System.out.printf("年龄：%d 年 %d 月 %d日",p.getYears(),p.getMonths(),p.getDays());
		
		p=p.minusMonths(1);
		System.out.printf("年龄：%d 年 %d 月 %d日",p.getYears(),p.getMonths(),p.getDays());
	}
	
	//Duration提供了使用基于时间的值（如秒，纳秒）测量时间量的方法。 
	private void testDuration(){
	
		Instant inst1= Instant.now();
		System.out.println(inst1);
		Instant inst2= inst1.plus(Duration.ofSeconds(10));
		System.out.println(inst2);
		
		Long mills=  Duration.between(inst1, inst2).toMillis();
		System.out.println("Difference in milliseconds : " + mills);
		Long seconds=  Duration.between(inst1, inst2).getSeconds();
		 System.out.println("Difference in seconds : " +seconds);
	}
	
	//ChronoUnit类可用于在单个时间单位内测量一段时间，例如天数或秒。 
    //	以下是使用between（）方法来查找两个日期之间的区别的示例。
	private void testChronoUnit(){
		
		LocalDate startDate=  LocalDate.of(1992, 11, 13);
		System.out.println("开始时间："+startDate);
		LocalDate nowDate= LocalDate.now();
		System.out.println("结束时间"+nowDate);
		
		Long daysDiff=   ChronoUnit.DAYS.between(startDate, nowDate);
		System.out.println(daysDiff);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
