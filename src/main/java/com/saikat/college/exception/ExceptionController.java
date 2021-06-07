package com.saikat.college.exception;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_404", LocalDateTime.now(), "NOT FOUND", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MandatoryFieldNotFoundException.class)
	public final ResponseEntity<Object> handleMandatoryFieldsNotFoundException(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_400", LocalDateTime.now(), "BAD REQUEST", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidArgumentException.class)
	public final ResponseEntity<Object> handleInvalidArguementsException(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_400", LocalDateTime.now(), "BAD REQUEST", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoArgumentsFoundException.class)
	public final ResponseEntity<Object> handleNoArguementsException(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_400", LocalDateTime.now(), "BAD REQUEST", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidArgumentOrMandatoryFieldNotFoundException.class)
	public final ResponseEntity<Object> handleInvalidArgumentOrMandatoryFieldNotFoundException(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_400", LocalDateTime.now(), "BAD REQUEST", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalServerError.class)
	public final ResponseEntity<Object> handleInternalServerError(Exception ex) {
		ExceptionResponse exResponse = new ExceptionResponse("ERROR_500", LocalDateTime.now(), "Internal Server Error", ex.getMessage());
		return new ResponseEntity<Object>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
