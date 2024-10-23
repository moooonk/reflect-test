本项目用于对比Java11和Java21下反射调用clone函数时性能差异

环境依赖：\
1.oracle jdk 11\
2.oracle jdk 21

运行方式：\
1.将gradle工程导入到ide环境中，分别以Java11和Java21运行SimpleTest.clsss，记录并对比控制台输出的测试用例耗时\~~~~
2.运行gradle jar，以java -jar 方式运行

注意：需要添加jvm参数--add-opens java.base/java.lang=ALL-UNNAMED，才能正确运行反射代码

case说明：\
case1：通过Object类的Clone方法直接反射无本地Clone方法的数据类Data\
case2：通过Object类的Clone方法直接反射有本地Clone方法的数据类DataWithClone\
case3：通过DataWithClone类的Clone方法自身本地的Clone方法的数据类DataWithClone

参考结果：\
Java11:\
case1:94\
case2:138\
case3:191

Java21;\
case1:12286\
case2:7437\
case3:970
