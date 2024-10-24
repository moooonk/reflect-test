本项目用于对比Java11和Java21下反射调用clone函数时性能差异\
This project used for compare the performance difference when reflection invoke clone method in Java 11 and Java 21.

环境依赖：\
dependent: \
1.oracle jdk 11\
2.oracle jdk 21

运行方式：\
Test Way:\
1.将gradle工程导入到ide环境中，分别以Java11和Java21运行SimpleTest.clsss，记录并对比控制台输出的测试用例耗时\
1.Import gradle project into ide,run SimpleTest.clsss in Java 11 and Java21 separately,record and compare the console log.\

2.运行gradle jar，以java -jar 方式运行\
2.Run `gradle jar` in cmd to package jar file, run application by `java -jar`.

注意：需要添加jvm参数--add-opens java.base/java.lang=ALL-UNNAMED，才能正确运行反射代码\
note:Need jvm args `--add-opens java.base/java.lang=ALL-UNNAMED` to run correctly.

case说明：\
case describe:\
case1：通过Object类的Clone方法直接反射无本地Clone方法的数据类Data\
case1: By Reflecting Object.class's clone method to invoke Data.class(no have clone method implement)

case2：通过Object类的Clone方法直接反射有本地Clone方法的数据类DataWithClone\
case2: By Reflecting Object.class's clone method to invoke DataWithClone.class(have clone method implement)

case3：通过DataWithClone类的Clone方法自身本地的Clone方法的数据类DataWithClone\
case3:By Reflecting DataWithClone.class's clone method to invoke DataWithClone.class(have clone method implement)

参考结果(I7 14700K)：\
Reference result(I7 14700K): \
Java11:\
case1:94\
case2:138\
case3:191

Java21;\
case1:12286\
case2:7437\
case3:970

测试显示同样的代码，在不同的测试用例下，Java21比Java11的反射Clone性能要低10~N倍，原因不明，有待探究
