package com.easy.office.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taylor
 * @ClassName: Converter
 * @Description:
 * @date: 2019-05-01 18:53
 */
public class Converter {

    /**
     * List converter to String.
     * @param list
     * @return
     */
    public static String ConverterToString(List<Integer> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("list can't Empty.");
        }
        return StringUtils.join(list.toArray()," ");
    }

    /**
     * String converter to List<Integer>
     * @param str
     * @return
     */
    public static List<Integer> ConverterToList(String str){
        List<Integer>list=new ArrayList<>();
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException("string can't Empty");
        }
        String[] arr= str.split("\\s");
        for(String index : arr){
            try{
                list.add(Integer.parseInt(index));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

        }
        return list;
    }
}
