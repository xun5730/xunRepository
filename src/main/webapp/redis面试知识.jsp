<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
一.redis是什么？

redis是nosql(也是个巨大的map) 单线程，但是可处理1秒10w的并发（数据都在内存中）

使用java对redis进行操作类似jdbc接口标准对mysql，有各类实现他的实现类，我们常用的是druid

其中对redis，我们通常用Jedis(也为我们提供了连接池JedisPool)

在redis中,key就是byte[](string)

redis的数据结构(value):

String,list,set,orderset,hash

二.应用场景:

String :

1存储json类型对象,2计数器,3优酷视频点赞等

list(双向链表)

1可以使用redis的list模拟队列,堆,栈

2朋友圈点赞(一条朋友圈内容语句,若干点赞语句)

规定:朋友圈内容的格式:

1,内容: user:x:post:x content来存储;

2,点赞: post:x:good list来存储;(把相应头像取出来显示)

hash(hashmap)

1保存对象

2分组
三.为什么redis是单线程的都那么快？

1.数据存于内存

2.用了多路复用I/O

3.单线程
五.redis也可以进行发布订阅消息吗？

可以，（然后可以引出哨兵模式（后面会讲）怎么互相监督的，就是因为每隔2秒哨兵节点会发布对某节点的判断和自身的信息到某频道，每个哨兵订阅该频道获取其他哨兵节点和主从节点的信息，
以达到哨兵间互相监控和对主从节点的监控）和很多专业的消息队列系统（例如Kafka、RocketMQ）相比，Redis的发布订阅略显粗糙，例如无法实现消息堆积和回溯。但胜在足够简单。
<img alt="" src="src/main/webapp/WEB-INF/image/发布订阅.jpg">
六.redis能否将数据持久化，如何实现？
能，将内存中的数据异步写入硬盘中，两种方式：RDB（默认）和AOF

RDB持久化原理：通过bgsave命令触发，然后父进程执行fork操作创建子进程，子进程创建RDB文件，根据父进程内存生成临时快照文件，完成后对原有文件进行原子替换（定时一次性将所有数据进行快照生成一份副本存储在硬盘中）

优点：是一个紧凑压缩的二进制文件，Redis加载RDB恢复数据远远快于AOF的方式。

缺点：由于每次生成RDB开销较大，非实时持久化，

AOF持久化原理：开启后，Redis每执行一个修改数据的命令，都会把这个命令添加到AOF文件中。

优点：实时持久化。

缺点：所以AOF文件体积逐渐变大，需要定期执行重写操作来降低文件体积，加载慢

七.主从复制模式下，主挂了怎么办？redis提供了哨兵模式（高可用）

何谓哨兵模式？就是通过哨兵节点进行自主监控主从节点以及其他哨兵节点，发现主节点故障时自主进行故障转移。

<img alt="" src="src/main/webapp/WEB-INF/image/主从.jpg">
八.哨兵模式实现原理？（2.8版本或更高才有）

1.三个定时监控任务：

1.1 每隔10s，每个S节点（哨兵节点）会向主节点和从节点发送info命令获取最新的拓扑结构

1.2 每隔2s，每个S节点会向某频道上发送该S节点对于主节点的判断以及当前Sl节点的信息，

同时每个Sentinel节点也会订阅该频道，来了解其他S节点以及它们对主节点的判断（做客观下线依据）

1.3 每隔1s，每个S节点会向主节点、从节点、其余S节点发送一条ping命令做一次心跳检测(心跳检测机制)，来确认这些节点当前是否可达

2.主客观下线：

2.1主观下线：根据第三个定时任务对没有有效回复的节点做主观下线处理

2.2客观下线：若主观下线的是主节点，会咨询其他S节点对该主节点的判断，超过半数，对该主节点做客观下线

3.选举出某一哨兵节点作为领导者，来进行故障转移。选举方式：raft算法。每个S节点有一票同意权，哪个S节点做出主观下线的时候，就会询问其他S节点是否同意其为领导者。获得半数选票的则成为领导者。基本谁先做出客观下线，谁成为领导者。

4.故障转移（选举新主节点流程）：

<img alt="" src="src/main/webapp/WEB-INF/image/主从原理.jpg">





10.1 key过期清除（超时剔除）策略

惰性过期（类比懒加载，这是懒过期）：只有当访问一个key时，才会判断该key是否已过期，过期则清除。该策略可以最大化地节省CPU资源，却对内存非常不友好。极端情况可能出现大量的过期key没有再次被访问，从而不会被清除，占用大量内存。

定期过期：每隔一定的时间，会扫描一定数量的数据库的expires字典中一定数量的key，并清除其中已过期的key。该策略是前两者的一个折中方案。通过调整定时扫描的时间间隔和每次扫描的限定耗时，可以在不同情况下使得CPU和内存资源达到最优的平衡效果。

(expires字典会保存所有设置了过期时间的key的过期时间数据，其中，key是指向键空间中的某个键的指针，value是该键的毫秒精度的UNIX时间戳表示的过期时间。键空间是指该Redis集群中保存的所有键。)

问：比如这么个场景，我设计了很多key，过期时间是5分钟，当前内存占用率是50%。但是5分钟到了，内存占用率还是很高，请问为什么？

Redis中同时使用了惰性过期和定期过期两种过期策略，即使过期时间到了，但是有部分并没有真正删除，等待惰性删除。

为什么有定期还要有惰性呢？其实很简单，比如10万个key就要过期了，Redis默认是100ms检查一波。如果他检查出10万个即将要清除，那他接下来的时间基本都是在干这些清空内存的事了，那肯定影响性能，所以他只会部分删除，剩下的等惰性

十.2 Redis的内存淘汰策略

Redis的内存淘汰策略是指在Redis的用于缓存的内存不足时，怎么处理需要新写入且需要申请额外空间的数据。

noeviction：当内存不足以容纳新写入数据时，新写入操作会报错。

allkeys-lru：当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的key。

allkeys-random：当内存不足以容纳新写入数据时，在键空间中，随机移除某个key。

volatile-lru：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，移除最近最少使用的key。

volatile-random：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，随机移除某个key。

volatile-ttl：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，有更早过期时间的key优先移除




</body>
</html>