package io.ssafy.soupapi.global.exception;

import io.ssafy.soupapi.global.common.ErrorResponse;
import io.ssafy.soupapi.global.common.code.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Objects;

@Log4j2
@RestControllerAdvice
public class GlobalControllerAdvice {
    // Custom ErrorCode를 기반으로 에러 처리
    @ExceptionHandler(BaseExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleCustomBaseExceptionHandler(BaseExceptionHandler e) {
        var response = ErrorResponse.fail(e.getErrorCode(), e.getMessage());

        return ResponseEntity.status(response.status()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodValidation(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        var response = ErrorResponse.fail(ErrorCode.NOT_VALID_ERROR,
                Objects.requireNonNull(bindingResult).getFieldErrors(),
                e.getMessage());

        return ResponseEntity.status(response.status()).body(response);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponse> handleHandlerMethodValidation(HandlerMethodValidationException e) {
        var response = ErrorResponse.fail(ErrorCode.NOT_VALID_ERROR, e.getMessage());

        return ResponseEntity.status(response.status()).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeExceptions(RuntimeException e) {
        e.printStackTrace();
        var response = ErrorResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());

        return ResponseEntity.status(response.status()).body(response);
    }

    /**
     * 예외 처리 되지 않은 모든 에러 처리
     *
     * @param e Exception
     * @return ResponseEntity
     */
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorResponse> handleAllExceptions(Exception e) {
        e.printStackTrace();
        var response = ErrorResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());

        return ResponseEntity.status(response.status()).body(response);
    }
}
