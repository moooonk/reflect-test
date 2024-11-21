package com.monk;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class RunBenchmark {

    private Data data;
    private DataWithOverride dataWithOverride;

    @Setup
    public void setup() {
        data = new Data();
        dataWithOverride = new DataWithOverride();
    }

    @Benchmark
    public void cloneCase1() {
        CloneTestCase.case1(data);
    }

    @Benchmark
    public void cloneCase2() {
        CloneTestCase.case2(dataWithOverride);
    }

    @Benchmark
    public void cloneCase3() {
        CloneTestCase.case3(dataWithOverride);
    }

    @Benchmark
    public void hashCodeCase1() {
        HashCodeTestCase.case1(data);
    }

    @Benchmark
    public void hashCodeCase2() {
        HashCodeTestCase.case2(dataWithOverride);
    }

    @Benchmark
    public void hashCodeCase3() {
        HashCodeTestCase.case3(dataWithOverride);
    }

    @Benchmark
    public void toStringCase1() {
        ToStringTestCase.case1(data);
    }

    @Benchmark
    public void toStringCase2() {
        ToStringTestCase.case2(dataWithOverride);
    }

    @Benchmark
    public void toStringCase3() {
        ToStringTestCase.case3(dataWithOverride);
    }

}
