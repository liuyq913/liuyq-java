package com.liuyq.java8.reduce;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuyq on 2019/9/19.
 */
public class ReduceTest {
    @Test
    public void main() {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer sum = stream.reduce(0, Integer::sum); //求和
        System.out.println(sum);

        stream.reduce((i, j) -> i + j).ifPresent(System.out::println); //qi

        stream.reduce(Integer::max).ifPresent(System.out::println);
    }

    @Test
    public void group() {
        List<Model> modelList = Lists.newArrayList();
        modelList.add(new Model(4, "2"));
        modelList.add(new Model(5, "2"));
        modelList.add(new Model(1, "1"));
        modelList.add(new Model(1, "2"));
        modelList.add(new Model(3, "2"));
        modelList.add(new Model(3, "2"));



        List<Model> models = modelList.stream().sorted(Comparator.comparing(Model::getPrice)).collect(Collectors.toList());

        Map<Double, List<Model>> maps = models.stream().collect(Collectors.groupingBy(t -> t.getPrice()));


    }

}
