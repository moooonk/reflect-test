此问题已被官方采纳，在JDK24+b27中修复：https://bugs.openjdk.org/browse/JDK-8343377

本项目用于对比Java17和Java21下反射调用clone函数时性能差异\
This project used for compare the performance difference when reflection invoke clone method in Java 17 and Java 21.

环境依赖：\
dependent: \
1.oracle jdk 17\
2.oracle jdk 21

运行方式：\
Test Way:\
将gradle工程导入到ide环境中，执行任务 `gradle jmh`\
Import gradle project into ide,run `gradle jmh`


注意：需要添加jvm参数--add-opens java.base/java.lang=ALL-UNNAMED，才能正确运行反射代码\
note:Need jvm args `--add-opens java.base/java.lang=ALL-UNNAMED` to run correctly.

case说明：\
case describe:\
case1：通过Object类的Clone方法直接反射无本地Clone方法的数据类Data\
case1: By Reflecting Object.class's clone method to invoke com.monk.Data.class(no have clone method implement)

case2：通过Object类的Clone方法直接反射有本地Clone方法的数据类DataWithOverride\
case2: By Reflecting Object.class's clone method to invoke com.monk.DataWithOverride.class(have clone method implement)

case3：通过DataWithClone类的Clone方法自身本地的Clone方法的数据类DataWithOverride\
case3:By Reflecting com.monk.DataWithOverride.class's clone method to invoke com.monk.DataWithOverride.class(have clone method implement)

HashCode测试用例和toString测试用例同上 \
HashCode case and toString are same like clone case.

参考结果(I7 14700K)：\
Reference result(I7 14700K): \
JDK17:\
Benchmark                    Mode  Cnt          Score          Error  Units\
RunBenchmark.cloneCase1     thrpt    5  830871722.632 ± 14902415.558  ops/s\
RunBenchmark.cloneCase2     thrpt    5  832256881.789 ±  9305066.153  ops/s\
RunBenchmark.cloneCase3     thrpt    5  827842981.397 ±  8629836.251  ops/s\
RunBenchmark.hashCodeCase1  thrpt    5  726644716.300 ±  4504879.585  ops/s\
RunBenchmark.hashCodeCase2  thrpt    5  726540126.956 ±  7249056.369  ops/s\
RunBenchmark.hashCodeCase3  thrpt    5  729054390.940 ± 11904383.303  ops/s\
RunBenchmark.toStringCase1  thrpt    5   42906690.075 ±   268508.159  ops/s\
RunBenchmark.toStringCase2  thrpt    5   41641490.800 ±   271577.545  ops/s\
RunBenchmark.toStringCase3  thrpt    5   41824727.616 ±   440507.690  ops/s

JDK21;\
Benchmark                    Mode  Cnt           Score          Error  Units\
RunBenchmark.cloneCase1     thrpt    5     8783640.822 ±    46196.518  ops/s\
RunBenchmark.cloneCase2     thrpt    5    13045394.145 ±   157121.364  ops/s\
RunBenchmark.cloneCase3     thrpt    5  2320020521.800 ± 56423864.542  ops/s\
RunBenchmark.hashCodeCase1  thrpt    5    11495229.964 ±   110515.482  ops/s\
RunBenchmark.hashCodeCase2  thrpt    5    11488996.620 ±    72449.931  ops/s\
RunBenchmark.hashCodeCase3  thrpt    5  1590063332.584 ± 15874384.555  ops/s\
RunBenchmark.toStringCase1  thrpt    5    40532553.791 ±   349765.261  ops/s\
RunBenchmark.toStringCase2  thrpt    5    40912699.225 ±   339420.788  ops/s\
RunBenchmark.toStringCase3  thrpt    5    40991023.028 ±   280145.682  ops/s~~~~

测试显示同样的代码，在不同的测试用例下，JDK21比JDK17的反射Clone,HashCode等native方法时性能出现显著下降，toString等非native方法则变化不明显
