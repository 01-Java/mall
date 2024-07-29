package com.smallschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object object;

    public Result success(){
        Result result = new Result(1,null,"成功");
        return result;
    }

    public Result success(Object object){
        Result result = new Result(1,"成功",object);
        return result;
    }

    public Result success(String msg){
        Result result = new Result(1,null,msg);
        return result;
    }

    public Result success(Object object ,String msg){
        Result result = new Result(1,msg,object);
        return result;
    }


    public Result error(String msg){
        Result result = new Result(0,null,msg);
        return result;
    }

    public Result error(){
        Result result = new Result(0,null,null);
        return result;
    }
}
