## 布隆过滤器

> 布隆过滤器用于检索一个元素是否在一个集合中
> 优点是空间效率和查询时间都比一般的算法要好很多，缺点是有一定的误识率和删除困难

运行 BloomFilterDemo 类文件测试 Bloom Filter 实际用法。该测试借助了 Google Guava 来作为 Bloom Filter 的底层实现。
> Google Guava 默认实现的误判率为 fpp = 0.03。