package com.icss.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 其他类型注入
 */
public class MoreType {
    private int[] arr;
    private List<String> list;
    private Set<String> set;
    private Map<Integer,String> map;
    private List<Dog> dogs;

    public MoreType() {
    }

    public MoreType(int[] arr, List<String> list, Set<String> set, Map<Integer, String> map, List<Dog> dogs) {
        this.arr = arr;
        this.list = list;
        this.set = set;
        this.map = map;
        this.dogs = dogs;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "MoreType{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", dogs=" + dogs +
                '}';
    }
}
