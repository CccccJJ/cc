import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.MessageFormat;
import java.util.stream.IntStream;


public class BloomFilterDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        final int total = 1000000;

        // fpp default is 0.03D
        final BloomFilter<CharSequence> bf = BloomFilter.create(
                Funnels.stringFunnel(Charsets.UTF_8),
                total/*, 0.0002*/);

        // 初始化 1000000 条数据到过滤器中
        IntStream.range(0, total).forEach(i -> {
            bf.put("" + i);
        });

        // 判断值是否存在过滤器中
        final long count = IntStream.range(0, total + 10000)
                .filter(predicate -> bf.mightContain("" + predicate))
                .count();

        // 匹配的数量：1,000,309
        // 309/(1000000 + 10000) * 100 ≈ 0.030594059405940593
        System.out.println(MessageFormat.format("匹配的数量：{0}", count));

    }

}
