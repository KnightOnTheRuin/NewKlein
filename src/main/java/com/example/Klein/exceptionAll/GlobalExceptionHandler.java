package com.example.Klein.exceptionAll;

import com.example.Klein.utils.result.DataResult;
import com.example.Klein.utils.result.Result;
import com.example.Klein.utils.result.code.Code;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.example.Klein")
public class GlobalExceptionHandler {
    /**
     * 出现异常返回错误提示, 并且回滚事务
     * @param e
     * @return
     */
   /* @Transactional(rollbackFor = Exception.class)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DataResult exceptionHandler(Exception e){
        System.out.println("抓到异常");
        //手动事务回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        //return Result.fail(400,"出现错误",null);
        return DataResult.errByErrCode(Code.ERROR);
    }*/


    @Transactional(rollbackFor = Exception.class)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result newexceptionHandler(Exception e){
        System.out.println("抓到异常");
        //手动事务回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return Result.fail(400,"出现错误",null);
        //return DataResult.errByErrCode(Code.ERROR);
    }
}
