package com.woailqw.simplevote.controller;

import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Base Controller
 *
 * @author Jack Pan
 * @version 1.00 2020-09-03
 */
public class BaseController {


    /**
     * Create error description
     *
     * @param bindingResult Error result
     * @return Error string.
     */
    protected String createErrorDescription(BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder errorDescription = new StringBuilder();
        for (ObjectError error : allErrors) {
            errorDescription.append(error.getDefaultMessage());
            errorDescription.append("</br>");
        }

        return errorDescription.toString();
    }
}
