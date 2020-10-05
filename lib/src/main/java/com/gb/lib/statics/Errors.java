package com.gb.lib.statics;

import com.gb.lib.exceptions.CException;

public class Errors {

    public static CException.Error RESPONSE_ERROR = new CException.Error(
            -171500001,
            "Wrong response",
            CException.Error.Type.E);

}
