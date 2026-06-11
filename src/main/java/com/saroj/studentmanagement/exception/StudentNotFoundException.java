//package com.saroj.studentmanagement.exception;
//
//
//public class StudentNotFoundException {
//
//	  public StudentNotFoundException(String message) {
//	        super(message);
//	    }
//}

package com.saroj.studentmanagement.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}