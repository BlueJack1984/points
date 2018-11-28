package com.tianbao.points.admin.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 统一异常处理
 * @author wujr 2018-09-13
 */
@RestControllerAdvice
@Slf4j
//@ControllerAdvice
public class ApplicationExceptionHandler {
//    @ExceptionHandler(value = DataIntegrityViolationException.class)
//    @ResponseBody
//    public OutputError uniqueHandle(DataIntegrityViolationException e){
//        ApplicationException ae = new ApplicationException(ApplicationException.DB_RECORD_DUPLICATED);
//        return new OutputError(ae.getCode(), ae.getMsg(), ae.getDetailMsg());
//    }
//    @ExceptionHandler(value = DuplicateKeyException.class)
//    @ResponseBody
//    public OutputError dupkeyHandler(DuplicateKeyException e){
//        ApplicationException ae = new ApplicationException(ApplicationException.DB_RECORD_DUPLICATED);
//        return new OutputError(ae.getCode(), ae.getMsg(), ae.getDetailMsg());
//    }
//    @ExceptionHandler(value = ApplicationException.class)
//    @ResponseBody
//    public OutputError appHandler(ApplicationException e){
//        return new OutputError(e.getCode(), e.getMsg(), e.getDetailMsg());
//    }
//    @ExceptionHandler(value = BindException.class)
//    @ResponseBody
//    public OutputError bindHandler(BindException e){
//        ApplicationException ae = new ApplicationException(ApplicationException.PARAM_ERROR);
//
//        StringBuilder sb = new StringBuilder();
//        BindingResult bindingResult = e.getBindingResult();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//        for (FieldError fieldError : fieldErrors){
//            sb.append(fieldError.getField())
//                    .append(": ")
//                    .append(fieldError.getDefaultMessage())
//                    .append("\r\n");
//        }
//        return new OutputError(ae.getCode(), ae.getMsg(), sb.toString());
//    }
//    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
//    @ResponseBody
//    public OutputError argumentMismatchHandler(MethodArgumentTypeMismatchException e){
//        ApplicationException ae = new ApplicationException(ApplicationException.PARAM_ERROR);
//        String msg = e.getName() + ": 数据类型不匹配";
//        return new OutputError(ae.getCode(), ae.getMsg(), msg);
//    }
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public OutputError exceptionHandle(Exception e){
//        Throwable throwable = e.getCause();
//        if (throwable != null && throwable.getCause() != null){
//            if (throwable.getCause() instanceof UndeclaredThrowableException){
//                UndeclaredThrowableException ut = (UndeclaredThrowableException)throwable.getCause();
//                Throwable throwable2 = ut.getUndeclaredThrowable();
//                if (throwable2 instanceof ApplicationException) {
//                    ApplicationException ae = (ApplicationException) throwable2;
//                    return new OutputError(ae.getCode(), ae.getMsg(), ae.getDetailMsg());
//                }
//            }
//        }
//
//        log.error("收到未知异常：{}", e);
//        return new OutputError(ApplicationException.INNER_ERROR, "未知错误", e.getMessage());
//    }
}
